package com.mall.distribution.application.port;

public interface JoinApproveUseCase {
    /**
     * 审核通过申请
     * @author wanmingcan
     */
    void approveJoin(Long joinId, String auditBy, String auditRemark);
}
