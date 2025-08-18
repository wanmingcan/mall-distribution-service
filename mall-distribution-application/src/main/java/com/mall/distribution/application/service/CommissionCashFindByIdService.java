package com.mall.distribution.application.service;

import com.mall.distribution.application.port.CommissionCashFindByIdUseCase;
import com.mall.distribution.domain.model.cash.CommissionCash;
import org.springframework.stereotype.Service;

/**
 * 根据ID查找提现申请应用服务
 */
@Service
public class CommissionCashFindByIdService implements CommissionCashFindByIdUseCase {
    @Override
    public CommissionCash findById(Long cashId) {
        return null;
    }
}
