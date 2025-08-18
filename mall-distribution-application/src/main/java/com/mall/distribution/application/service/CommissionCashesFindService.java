package com.mall.distribution.application.service;

import com.mall.distribution.application.port.CommissionCashesFindUseCase;
import com.mall.distribution.application.query.CommissionCashQuery;
import com.mall.distribution.domain.model.cash.CommissionCash;

import java.util.List;

public class CommissionCashesFindService implements CommissionCashesFindUseCase {
    @Override
    public List<CommissionCash> findCommissionCashes(CommissionCashQuery query) {
        return List.of();
    }
}
