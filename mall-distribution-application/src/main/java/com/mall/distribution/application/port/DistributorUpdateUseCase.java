package com.mall.distribution.application.port;

import com.mall.distribution.application.command.UpdateDistributorCommand;

public interface DistributorUpdateUseCase {
    /**
     * 更新分销商
     * @author wanmingcan
     */
    void updateDistributor(UpdateDistributorCommand command);
}
