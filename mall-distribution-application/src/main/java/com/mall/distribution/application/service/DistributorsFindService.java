package com.mall.distribution.application.service;

import com.mall.distribution.application.port.DistributorsFindUseCase;
import com.mall.distribution.application.query.DistributorQuery;
import com.mall.distribution.domain.model.distributor.Distributor;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 查询分销商列表应用服务
 */
@Service
public class DistributorsFindService implements DistributorsFindUseCase {
    @Override
    public List<Distributor> findDistributors(DistributorQuery query) {
        return List.of();
    }
}
