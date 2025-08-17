package com.mall.distribution.application.service;

import com.mall.distribution.application.command.CreateCommissionCashCommand;
import com.mall.distribution.application.port.CommissionCashUseCase;
import com.mall.distribution.application.port.DistributorUseCase;
import com.mall.distribution.application.query.CommissionCashQuery;
import com.mall.distribution.common.exception.BusinessException;
import com.mall.distribution.common.exception.Resp;
import com.mall.distribution.domain.commission.CommissionCash;
import com.mall.distribution.domain.commission.CommissionCashRepository;
import com.mall.distribution.domain.distributor.Distributor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 佣金提现应用服务
 */
@Service
@RequiredArgsConstructor
public class CommissionCashService implements CommissionCashUseCase {
    
    private final CommissionCashRepository commissionCashRepository;
    private final DistributorUseCase distributorUseCase;
    
    @Override
    @Transactional
    public Long createCommissionCash(CreateCommissionCashCommand command) {
        // 查找分销商
        Distributor distributor = distributorUseCase.findById(command.getDistributorId());
        
        // 检查佣金余额是否足够
        if (distributor.getCommissionBalance().compareTo(command.getCashAmount()) < 0) {
            throw new BusinessException(Resp.COMMISSION_BALANCE_INSUFFICIENT);
        }
        
        // 创建提现申请
        CommissionCash commissionCash = CommissionCash.create(
            command.getDistributorId(),
            command.getCashAmount(),
            command.getBankCard(),
            command.getBankName(),
            command.getBankBranch(),
            command.getCreatedBy()
        );
        
        // 保存提现申请
        commissionCashRepository.save(commissionCash);
        
        return commissionCash.getCashId();
    }
    
    @Override
    public CommissionCash findById(Long cashId) {
        return commissionCashRepository.findById(cashId)
            .orElseThrow(() -> new BusinessException(Resp.COMMISSION_CASH_NOT_FOUND));
    }
    
    @Override
    public List<CommissionCash> findCommissionCashes(CommissionCashQuery query) {
        return commissionCashRepository.findByQuery(query);
    }
    
    @Override
    @Transactional
    public void approveCash(Long cashId, String auditBy, String auditRemark) {
        CommissionCash commissionCash = findById(cashId);
        commissionCash.approve(auditBy, auditRemark);
        commissionCashRepository.save(commissionCash);
    }
    
    @Override
    @Transactional
    public void rejectCash(Long cashId, String auditBy, String auditRemark) {
        CommissionCash commissionCash = findById(cashId);
        commissionCash.reject(auditBy, auditRemark);
        commissionCashRepository.save(commissionCash);
    }
    
    @Override
    @Transactional
    public void payCash(Long cashId, String paymentNo, String paidBy) {
        CommissionCash commissionCash = findById(cashId);
        commissionCash.pay(paymentNo, paidBy);
        commissionCashRepository.save(commissionCash);
        
        // 扣减分销商佣金余额
        distributorUseCase.updateCommissionBalance(
            commissionCash.getDistributorId(), 
            commissionCash.getCashAmount().negate(), 
            paidBy
        );
    }
}