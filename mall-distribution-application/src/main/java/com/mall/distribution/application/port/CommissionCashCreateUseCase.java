package com.mall.distribution.application.port;

import com.mall.distribution.application.command.CreateCommissionCashCommand;

public interface CommissionCashCreateUseCase {
    /**
     * 创建佣金提现申请
     */
    Long createCommissionCash(CreateCommissionCashCommand command);
}
