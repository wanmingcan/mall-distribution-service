package com.mall.distribution.application.service;

import com.mall.distribution.application.command.CreateDistributorJoinCommand;
import com.mall.distribution.application.query.DistributorJoinQuery;
import com.mall.distribution.common.exception.BusinessException;

import com.mall.distribution.domain.model.join.DistributorJoin;
import com.mall.distribution.domain.repository.DistributorJoinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * 分销商申请应用服务
 * @author wanmingcan
 */
@Service
@RequiredArgsConstructor
public class DistributorJoinService implements DistributorJoinUseCase {

    private final DistributorJoinRepository distributorJoinRepository;

    @Override
    @Transactional
    public Long createDistributorJoin(CreateDistributorJoinCommand command) {
        // 检查用户是否有待审核的申请
        if (distributorJoinRepository.existsPendingByUserId(command.getUserId())) {
            throw new BusinessException(Resp.DISTRIBUTOR_JOIN_PENDING_EXISTS);
        }

        // 创建申请
        DistributorJoin distributorJoin = DistributorJoin.create(
            command.getUserId(),
            command.getApplicantName(),
            command.getPhone(),
            command.getIdCard(),
            command.getIdCardFront(),
            command.getIdCardBack(),
            command.getBankCard(),
            command.getBankName(),
            command.getBankBranch(),
            command.getReason(),
            command.getCreatedBy()
        );

        // 保存申请
        distributorJoinRepository.save(distributorJoin);

        return distributorJoin.getJoinId();
    }

    @Override
    public DistributorJoin findById(Long joinId) {
        return distributorJoinRepository.findById(joinId)
            .orElseThrow(() -> new BusinessException(Resp.DISTRIBUTOR_JOIN_NOT_FOUND));
    }

    @Override
    public List<DistributorJoin> findDistributorJoins(DistributorJoinQuery query) {
        return distributorJoinRepository.findByQuery(query);
    }

    @Override
    @Transactional
    public void approveJoin(Long joinId, String auditBy, String auditRemark) {
        DistributorJoin distributorJoin = findById(joinId);
        distributorJoin.approve(auditBy, auditRemark);
        distributorJoinRepository.save(distributorJoin);
    }

    @Override
    @Transactional
    public void rejectJoin(Long joinId, String auditBy, String auditRemark) {
        DistributorJoin distributorJoin = findById(joinId);
        distributorJoin.reject(auditBy, auditRemark);
        distributorJoinRepository.save(distributorJoin);
    }

    @Override
    public boolean existsPendingByUserId(Long userId) {
        return distributorJoinRepository.existsPendingByUserId(userId);
    }
}
