package com.mall.distribution.application.port;
/**
 * 启用分销商
 * @author wanmingcan
 */
public interface DistributorEnableUseCase {

    void enableDistributor(Long distributorId, String updatedBy);
}
