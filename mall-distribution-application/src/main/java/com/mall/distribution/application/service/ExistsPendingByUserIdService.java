package com.mall.distribution.application.service;

import com.mall.distribution.application.port.ExistsPendingByUserIdUseCase;

public class ExistsPendingByUserIdService implements ExistsPendingByUserIdUseCase{
    @Override
    public boolean existsPendingByUserId(Long userId) {
        return false;
    }
}
