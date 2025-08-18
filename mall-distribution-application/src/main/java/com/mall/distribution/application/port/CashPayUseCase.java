package com.mall.distribution.application.port;

public interface CashPayUseCase {
    /**
     * 支付提现申请
     * @author wanmingcan
     */
    void payCash(Long cashId, String paymentNo, String paidBy);
}
