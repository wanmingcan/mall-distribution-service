package com.mall.distribution.application.port;

import com.mall.distribution.application.command.CreateDistributorJoinCommand;

public interface DistributorJoinCreateUseCase {
    /**
     * 创建分销商申请
     */
    Long createDistributorJoin(CreateDistributorJoinCommand command);
}
