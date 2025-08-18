package com.mall.distribution.application.port;

public interface DistributorEnableUseCase {
    /**
     * 启用分销商
     * @author wanmingcan
     */
    void enableDistributor(Long distributorId, String updatedBy);
}
