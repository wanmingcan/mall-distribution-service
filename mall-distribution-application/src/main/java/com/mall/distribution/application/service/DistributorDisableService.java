package com.mall.distribution.application.service;

import com.mall.distribution.application.port.DistributorDisableUseCase;
import org.springframework.stereotype.Service;

/**
 * 禁用分销商应用服务
 * @author wanmingcan
 */
@Service
public class DistributorDisableService implements DistributorDisableUseCase {
    @Override
    public void disableDistributor(Long distributorId, String updatedBy) {

    }
}
