package com.mall.distribution.application.port;

import com.mall.distribution.application.command.UpdateDistributorCommand;
/**
 * 更新分销商
 * @author wanmingcan
 */
public interface DistributorUpdateUseCase {

    void updateDistributor(UpdateDistributorCommand command);
}
