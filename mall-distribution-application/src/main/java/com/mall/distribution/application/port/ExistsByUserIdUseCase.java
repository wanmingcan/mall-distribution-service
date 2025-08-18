package com.mall.distribution.application.port;

public interface ExistsByUserIdUseCase {
    /**
     * 检查用户是否已是分销商
     * @author wanmingcan
     */
    boolean existsByUserId(Long userId);
}
