package com.mall.distribution.application.port;

import com.mall.distribution.application.query.CommissionCashQuery;
import com.mall.distribution.domain.model.cash.CommissionCash;

import java.util.List;

public interface CommissionCashesFindUseCase {
    /**
     * 查询提现申请列表
     */
    List<CommissionCash> findCommissionCashes(CommissionCashQuery query);
}
