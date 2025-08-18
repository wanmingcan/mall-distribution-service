package com.mall.distribution.application.service;

import com.mall.distribution.application.port.ExistsByUserIdUseCase;
import org.springframework.stereotype.Service;
/**
 * 检查用户是否已是分销商
 */
@Service
public class ExistsByUserIdService implements ExistsByUserIdUseCase {
    @Override
    public boolean existsByUserId(Long userId) {
        return false;
    }
}
