package com.mall.distribution.application.port;

import com.mall.distribution.application.query.CommissionCashQuery;
import com.mall.distribution.domain.model.cash.CommissionCash;

import java.util.List;
/**
 * 查询提现申请列表
 * @author wanmingcan
 */
public interface CommissionCashesFindUseCase {

    List<CommissionCash> findCommissionCashes(CommissionCashQuery query);
}
