package com.mall.distribution.application.service;

import com.mall.distribution.application.port.ExistsByUserIdUseCase;
import org.springframework.stereotype.Service;
/**
 * 检查身份证号是否已存在应用服务
 * @author wanmingcan
 */
@Service
public class ExistsByIdCardService implements ExistsByUserIdUseCase {

    @Override
    public boolean existsByUserId(Long userId) {
        return false;
    }
}
