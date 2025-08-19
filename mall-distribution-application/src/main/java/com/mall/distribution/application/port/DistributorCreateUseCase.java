package com.mall.distribution.application.port;

import com.mall.distribution.application.command.CreateDistributorCommand;
/**
 * 创建分销商
 * @author wanmingcan
 */
public interface DistributorCreateUseCase {

    Long createDistributor(CreateDistributorCommand command);
}
