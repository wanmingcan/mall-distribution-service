package com.mall.distribution.application.service;

import com.mall.distribution.application.port.DistributorEnableUseCase;
import org.springframework.stereotype.Service;
/**
 * 启用分销商应用服务
 * @author wanmingcan
 */
@Service
public class DistributorEnableService implements DistributorEnableUseCase {
    @Override
    public void enableDistributor(Long distributorId, String updatedBy) {

    }
}
