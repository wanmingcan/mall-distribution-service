package com.mall.distribution.application.port;

import com.mall.distribution.application.query.DistributorQuery;
import com.mall.distribution.domain.model.distributor.Distributor;

import java.util.List;
/**
 * 查询分销商列表
 * @author wanmingcan
 */
public interface DistributorsFindUseCase {

    List<Distributor> findDistributors(DistributorQuery query);
}
