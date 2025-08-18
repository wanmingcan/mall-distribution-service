package com.mall.distribution.application.service;

import com.mall.distribution.application.port.CommissionCashesFindUseCase;
import com.mall.distribution.application.query.CommissionCashQuery;
import com.mall.distribution.domain.model.cash.CommissionCash;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 查询提现申请列表应用服务
 * @author wanmingcan
 */
@Service
public class CommissionCashesFindService implements CommissionCashesFindUseCase {
    @Override
    public List<CommissionCash> findCommissionCashes(CommissionCashQuery query) {
        return List.of();
    }
}
