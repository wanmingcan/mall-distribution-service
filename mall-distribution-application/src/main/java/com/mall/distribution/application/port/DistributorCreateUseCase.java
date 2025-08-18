package com.mall.distribution.application.port;

import com.mall.distribution.application.command.CreateDistributorCommand;

public interface DistributorCreateUseCase {
    /**
     * 创建分销商
     */
    Long createDistributor(CreateDistributorCommand command);
}
