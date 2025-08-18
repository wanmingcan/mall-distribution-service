package com.mall.distribution.application.port;

public interface CashRejectUseCase {
    /**
     * 拒绝提现申请
     */
    void rejectCash(Long cashId, String auditBy, String auditRemark);
}
