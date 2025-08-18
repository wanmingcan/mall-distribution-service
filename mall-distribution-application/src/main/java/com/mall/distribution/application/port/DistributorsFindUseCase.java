package com.mall.distribution.application.port;

import com.mall.distribution.application.query.DistributorQuery;
import com.mall.distribution.domain.model.distributor.Distributor;

import java.util.List;

public interface DistributorsFindUseCase {
    /**
     * 查询分销商列表
     */
    List<Distributor> findDistributors(DistributorQuery query);
}
