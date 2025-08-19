package com.mall.distribution.application.port;
/**
 * 检查手机号是否已存在
 * @author wanmingcan
 */
public interface ExistsByPhoneUseCase {

    boolean existsByPhone(String phone);
}
