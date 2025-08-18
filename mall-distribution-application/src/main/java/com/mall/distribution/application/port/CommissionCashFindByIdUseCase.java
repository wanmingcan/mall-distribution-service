package com.mall.distribution.application.port;

import com.mall.distribution.domain.model.cash.CommissionCash;

public interface CommissionCashFindByIdUseCase {
    /**
     * 根据ID查找提现申请
     * @author wanmingcan
     */
    CommissionCash findById(Long cashId);
}
