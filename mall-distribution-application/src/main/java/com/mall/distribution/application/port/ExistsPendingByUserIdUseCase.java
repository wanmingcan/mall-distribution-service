package com.mall.distribution.application.port;
/**
 * 检查用户是否有待审核的申请
 * @author wanmingcan
 */
public interface ExistsPendingByUserIdUseCase {

    boolean existsPendingByUserId(Long userId);
}
