package com.mall.distribution.application.service;

import com.mall.distribution.application.port.CommissionBalanceUpdateUseCase;

import java.math.BigDecimal;

public class CommissionBalanceUpdateService implements CommissionBalanceUpdateUseCase{
    @Override
    public void updateCommissionBalance(Long distributorId, BigDecimal amount, String updatedBy) {

    }
}
