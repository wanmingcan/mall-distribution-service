package com.mall.distribution.application.service;

import com.mall.distribution.application.port.ExistsByPhoneUseCase;
import org.springframework.stereotype.Service;
/**
 * 检查手机号是否已存在应用服务
 * @author wanmingcan
 */
@Service
public class ExistsByPhoneService implements ExistsByPhoneUseCase {
    @Override
    public boolean existsByPhone(String phone) {
        return false;
    }
}
