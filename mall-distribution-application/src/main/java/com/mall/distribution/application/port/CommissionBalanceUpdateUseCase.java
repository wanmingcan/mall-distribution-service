package com.mall.distribution.application.port;

import java.math.BigDecimal;
/**
 * 更新佣金余额
 * @author wanmingcan
 */
public interface CommissionBalanceUpdateUseCase {

    void updateCommissionBalance(Long distributorId, BigDecimal amount, String updatedBy);
}
