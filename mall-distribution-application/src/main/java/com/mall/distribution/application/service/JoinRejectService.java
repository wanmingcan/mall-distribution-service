package com.mall.distribution.application.service;

import com.mall.distribution.application.port.JoinRejectUseCase;
import org.springframework.stereotype.Service;

/**
 * 拒绝申请应用服务
 */
@Service
public class JoinRejectService implements JoinRejectUseCase {
    @Override
    public void rejectJoin(Long joinId, String auditBy, String auditRemark) {

    }
}
