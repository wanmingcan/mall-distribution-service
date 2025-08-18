package com.mall.distribution.application.service;

import com.mall.distribution.application.port.CashApproveUseCase;
import org.springframework.stereotype.Service;

/**
 * 审核通过提现申请应用服务
 * @author wanmingcan
 */
@Service
public class CashApproveService implements CashApproveUseCase {
    @Override
    public void approveCash(Long cashId, String auditBy, String auditRemark) {

    }
}
