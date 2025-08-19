package com.mall.distribution.application.port;
/**
 * 拒绝申请
 * @author wanmingcan
 */
public interface JoinRejectUseCase {

    void rejectJoin(Long joinId, String auditBy, String auditRemark);
}
