package com.mall.distribution.application.service;

import com.mall.distribution.application.command.CreateCommissionCashCommand;
import com.mall.distribution.application.port.CommissionCashCreateUseCase;
import org.springframework.stereotype.Service;

/**
 * 创建佣金提现申请应用服务
 */
@Service
public class CommissionCashCreateService implements CommissionCashCreateUseCase {
    @Override
    public Long createCommissionCash(CreateCommissionCashCommand command) {
        return null;
    }
}
