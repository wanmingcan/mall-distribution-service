package com.mall.distribution.application.port;

import java.math.BigDecimal;

public interface CommissionBalanceUpdateUseCase {
    /**
     * 更新佣金余额
     * @author wanmingcan
     */
    void updateCommissionBalance(Long distributorId, BigDecimal amount, String updatedBy);
}
