package com.mall.distribution.application.port;
/**
 * 禁用分销商
 * @author wanmingcan
 */
public interface DistributorDisableUseCase {

    void disableDistributor(Long distributorId, String updatedBy);
}
