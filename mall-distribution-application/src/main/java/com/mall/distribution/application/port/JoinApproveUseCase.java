package com.mall.distribution.application.port;
/**
 * 审核通过申请
 * @author wanmingcan
 */
public interface JoinApproveUseCase {

    void approveJoin(Long joinId, String auditBy, String auditRemark);
}
