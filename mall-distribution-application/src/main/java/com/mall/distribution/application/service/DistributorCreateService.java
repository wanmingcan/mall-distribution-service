package com.mall.distribution.application.service;

import com.mall.distribution.application.command.CreateDistributorCommand;
import com.mall.distribution.application.port.DistributorCreateUseCase;
import org.springframework.stereotype.Service;

/**
 * 创建分销商应用服务
 */
@Service
public class DistributorCreateService implements DistributorCreateUseCase {
    @Override
    public Long createDistributor(CreateDistributorCommand command) {
        return null;
    }
}
