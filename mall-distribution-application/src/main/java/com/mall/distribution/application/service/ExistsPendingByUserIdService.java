package com.mall.distribution.application.service;

import com.mall.distribution.application.port.ExistsPendingByUserIdUseCase;
import org.springframework.stereotype.Service;

/**
 * 检查用户是否有待审核的申请应用服务
 */
@Service
public class ExistsPendingByUserIdService implements ExistsPendingByUserIdUseCase{
    @Override
    public boolean existsPendingByUserId(Long userId) {
        return false;
    }
}
