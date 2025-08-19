package com.mall.distribution.application.port;
/**
 * 拒绝提现申请
 * @author wanmingcan
 */
public interface CashRejectUseCase {

    void rejectCash(Long cashId, String auditBy, String auditRemark);
}
