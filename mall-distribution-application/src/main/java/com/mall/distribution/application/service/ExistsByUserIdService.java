package com.mall.distribution.application.service;

import com.mall.distribution.application.port.ExistsByUserIdUseCase;

public class ExistsByUserIdService implements ExistsByUserIdUseCase {
    @Override
    public boolean existsByUserId(Long userId) {
        return false;
    }
}
