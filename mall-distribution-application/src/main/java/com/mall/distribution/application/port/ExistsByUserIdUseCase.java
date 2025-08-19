package com.mall.distribution.application.port;
/**
 * 检查用户是否已是分销商
 * @author wanmingcan
 */
public interface ExistsByUserIdUseCase {

    boolean existsByUserId(Long userId);
}
