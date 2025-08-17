package com.mall.distribution.application.port;

import com.mall.distribution.application.command.CreateCommissionCashCommand;
import com.mall.distribution.application.query.CommissionCashQuery;
import com.mall.distribution.domain.commission.CommissionCash;

import java.util.List;

/**
 * 佣金提现用例接口
 */
public interface CommissionCashUseCase {
    
    /**
     * 创建佣金提现申请
     */
    Long createCommissionCash(CreateCommissionCashCommand command);
    
    /**
     * 根据ID查找提现申请
     */
    CommissionCash findById(Long cashId);
    
    /**
     * 查询提现申请列表
     */
    List<CommissionCash> findCommissionCashes(CommissionCashQuery query);
    
    /**
     * 审核通过提现申请
     */
    void approveCash(Long cashId, String auditBy, String auditRemark);
    
    /**
     * 拒绝提现申请
     */
    void rejectCash(Long cashId, String auditBy, String auditRemark);
    
    /**
     * 支付提现申请
     */
    void payCash(Long cashId, String paymentNo, String paidBy);
}