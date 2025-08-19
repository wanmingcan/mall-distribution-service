package com.mall.distribution.application.port;
/**
 * 检查身份证号是否已存在
 * @author wanmingcan
 */
public interface ExistsByIdCardUseCase {

    boolean existsByIdCard(String idCard);
}
