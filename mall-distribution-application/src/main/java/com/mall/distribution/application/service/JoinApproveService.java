package com.mall.distribution.application.service;

import com.mall.distribution.application.port.JoinApproveUseCase;
import org.springframework.stereotype.Service;

/**
 * 审核通过申请应用服务
 * @author wanmingcan
 */
@Service
public class JoinApproveService implements JoinApproveUseCase {
    @Override
    public void approveJoin(Long joinId, String auditBy, String auditRemark) {

    }
}
