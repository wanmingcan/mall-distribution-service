package com.mall.distribution.application.port;
/**
 * 审核通过提现申请
 * @author wanmingcan
 */
public interface CashApproveUseCase{

    void approveCash(Long cashId, String auditBy, String auditRemark);
}
