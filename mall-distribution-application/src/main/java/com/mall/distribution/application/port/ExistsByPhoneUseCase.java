package com.mall.distribution.application.port;

public interface ExistsByPhoneUseCase {
    /**
     * 检查手机号是否已存在
     */
    boolean existsByPhone(String phone);
}
