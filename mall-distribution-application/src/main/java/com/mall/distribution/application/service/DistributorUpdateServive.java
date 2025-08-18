package com.mall.distribution.application.service;

import com.mall.distribution.application.command.UpdateDistributorCommand;
import com.mall.distribution.application.port.DistributorUpdateUseCase;
import org.springframework.stereotype.Service;

/**
 * 更新分销商应用服务
 */
@Service
public class DistributorUpdateServive implements DistributorUpdateUseCase {
    @Override
    public void updateDistributor(UpdateDistributorCommand command) {

    }
}
