package com.mall.distribution.application.port;

import com.mall.distribution.application.command.CreateCommissionCashCommand;
/**
 * 创建佣金提现申请
 * @author wanmingcan
 */
public interface CommissionCashCreateUseCase {

    Long createCommissionCash(CreateCommissionCashCommand command);
}
