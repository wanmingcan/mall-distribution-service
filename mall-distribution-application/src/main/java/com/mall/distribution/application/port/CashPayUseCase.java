package com.mall.distribution.application.port;
/**
 * 支付提现申请
 * @author wanmingcan
 */
public interface CashPayUseCase {

    void payCash(Long cashId, String paymentNo, String paidBy);
}
