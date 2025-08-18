package com.mall.distribution.application.port;

public interface JoinRejectUseCase {
    /**
     * 拒绝申请
     */
    void rejectJoin(Long joinId, String auditBy, String auditRemark);
}
