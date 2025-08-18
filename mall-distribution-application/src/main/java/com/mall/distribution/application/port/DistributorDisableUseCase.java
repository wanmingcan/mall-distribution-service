package com.mall.distribution.application.port;

public interface DistributorDisableUseCase {
    /**
     * 禁用分销商
     * @author wanmingcan
     */
    void disableDistributor(Long distributorId, String updatedBy);
}
