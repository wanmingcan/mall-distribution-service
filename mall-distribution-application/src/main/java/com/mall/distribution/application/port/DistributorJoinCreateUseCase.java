package com.mall.distribution.application.port;

import com.mall.distribution.application.command.CreateDistributorJoinCommand;
/**
 * 创建分销商申请
 * @author wanmingcan
 */
public interface DistributorJoinCreateUseCase {

    Long createDistributorJoin(CreateDistributorJoinCommand command);
}
