package com.mall.distribution.application.service;

import com.mall.distribution.application.port.DistributorFindByUserIdUseCase;
import com.mall.distribution.domain.model.distributor.Distributor;
import org.springframework.stereotype.Service;
/**
 * 根据用户ID查找分销商应用服务
 */
@Service
public class DistributorFindByUserIdService implements DistributorFindByUserIdUseCase {
    @Override
    public Distributor findByUserId(Long userId) {
        return null;
    }
}
