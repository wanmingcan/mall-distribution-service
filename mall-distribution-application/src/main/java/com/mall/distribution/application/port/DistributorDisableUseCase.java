package com.mall.distribution.application.port;

public interface DistributorDisableUseCase {
    /**
     * 禁用分销商
     */
    void disableDistributor(Long distributorId, String updatedBy);
}
