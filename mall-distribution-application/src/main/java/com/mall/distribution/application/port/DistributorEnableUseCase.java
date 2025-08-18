package com.mall.distribution.application.port;

public interface DistributorEnableUseCase {
    /**
     * 启用分销商
     */
    void enableDistributor(Long distributorId, String updatedBy);
}
