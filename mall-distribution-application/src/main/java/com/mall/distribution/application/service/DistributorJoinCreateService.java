package com.mall.distribution.application.service;

import com.mall.distribution.application.command.CreateDistributorJoinCommand;
import com.mall.distribution.application.port.DistributorJoinCreateUseCase;
import org.springframework.stereotype.Service;

/**
 * 创建分销商申请应用服务
 * @author wanmingcan
 */
@Service
public class DistributorJoinCreateService implements DistributorJoinCreateUseCase{

    @Override
    public Long createDistributorJoin(CreateDistributorJoinCommand command) {
        return null;
    }
}
