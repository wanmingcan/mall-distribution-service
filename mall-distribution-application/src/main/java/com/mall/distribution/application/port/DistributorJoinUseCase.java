package com.mall.distribution.application.port;

import com.mall.distribution.application.command.CreateDistributorJoinCommand;
import com.mall.distribution.application.query.DistributorJoinQuery;
import com.mall.distribution.domain.distributor.DistributorJoin;

import java.util.List;

/**
 * 分销商申请用例接口
 */
public interface DistributorJoinUseCase {
    
    /**
     * 创建分销商申请
     */
    Long createDistributorJoin(CreateDistributorJoinCommand command);
    
    /**
     * 根据ID查找申请
     */
    DistributorJoin findById(Long joinId);
    
    /**
     * 查询申请列表
     */
    List<DistributorJoin> findDistributorJoins(DistributorJoinQuery query);
    
    /**
     * 审核通过申请
     */
    void approveJoin(Long joinId, String auditBy, String auditRemark);
    
    /**
     * 拒绝申请
     */
    void rejectJoin(Long joinId, String auditBy, String auditRemark);
    
    /**
     * 检查用户是否有待审核的申请
     */
    boolean existsPendingByUserId(Long userId);
}