package com.mall.distribution.application.service;

import com.mall.distribution.application.port.DistributorsFindUseCase;
import com.mall.distribution.application.query.DistributorQuery;
import com.mall.distribution.domain.model.distributor.Distributor;

import java.util.List;

public class DistributorsFindService implements DistributorsFindUseCase {
    @Override
    public List<Distributor> findDistributors(DistributorQuery query) {
        return List.of();
    }
}
