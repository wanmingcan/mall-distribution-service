package com.mall.distribution.application.port;

public interface ExistsByIdCardUseCase {
    /**
     * 检查身份证号是否已存在
     * @author wanmingcan
     */
    boolean existsByIdCard(String idCard);
}
