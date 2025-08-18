package com.mall.distribution.application.service;

import com.mall.distribution.application.port.CashRejectUseCase;
import org.springframework.stereotype.Service;

/**
 * 拒绝提现申请应用服务
 * @author wanmingcan
 */
@Service
public class CashRejectService implements CashRejectUseCase {
    @Override
    public void rejectCash(Long cashId, String auditBy, String auditRemark) {

    }
}
