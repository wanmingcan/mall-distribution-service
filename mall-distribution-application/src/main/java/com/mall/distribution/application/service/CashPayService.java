package com.mall.distribution.application.service;

import com.mall.distribution.application.port.CashPayUseCase;
import org.springframework.stereotype.Service;

/**
 * 支付提现申请应用服务
 * @author wanmingcan
 */
@Service
public class CashPayService implements CashPayUseCase {
    @Override
    public void payCash(Long cashId, String paymentNo, String paidBy) {

    }
}
