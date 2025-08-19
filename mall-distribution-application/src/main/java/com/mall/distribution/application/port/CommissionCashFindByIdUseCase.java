package com.mall.distribution.application.port;

import com.mall.distribution.domain.model.cash.CommissionCash;
/**
 * 根据ID查找提现申请
 * @author wanmingcan
 */
public interface CommissionCashFindByIdUseCase {

    CommissionCash findById(Long cashId);
}
