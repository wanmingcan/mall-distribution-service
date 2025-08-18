package com.mall.distribution.application.port;

public interface CashApproveUseCase{
    /**
     * 审核通过提现申请
     * @author wanmingcan
     */
    void approveCash(Long cashId, String auditBy, String auditRemark);
}
