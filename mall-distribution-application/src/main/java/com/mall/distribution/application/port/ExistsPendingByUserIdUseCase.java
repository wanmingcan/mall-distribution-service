package com.mall.distribution.application.port;

public interface ExistsPendingByUserIdUseCase {
    /**
     * 检查用户是否有待审核的申请
     */
    boolean existsPendingByUserId(Long userId);
}
