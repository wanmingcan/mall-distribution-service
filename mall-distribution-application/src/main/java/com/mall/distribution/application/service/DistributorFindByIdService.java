package com.mall.distribution.application.service;

import com.mall.distribution.application.port.DistributorFindByIdUseCase;
import com.mall.distribution.domain.model.distributor.Distributor;
import org.springframework.stereotype.Service;

/**
 * 根据ID查找申请应用服务
 * @author wanmingcan
 */
@Service
public class DistributorFindByIdService implements DistributorFindByIdUseCase {
    @Override
    public Distributor findById(Long distributorId) {
        return null;
    }
}
