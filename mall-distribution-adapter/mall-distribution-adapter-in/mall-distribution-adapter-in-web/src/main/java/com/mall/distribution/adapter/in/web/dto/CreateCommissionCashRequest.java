package com.mall.distribution.adapter.in.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 创建佣金提现请求
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "创建佣金提现请求")
public class CreateCommissionCashRequest {
    
    @NotNull(message = "分销商ID不能为空")
    @Schema(description = "分销商ID", example = "1")
    private Long distributorId;
    
    @NotNull(message = "提现金额不能为空")
    @DecimalMin(value = "0.01", message = "提现金额必须大于0")
    @Schema(description = "提现金额", example = "100.00")
    private BigDecimal cashAmount;
    
    @NotBlank(message = "银行卡号不能为空")
    @Schema(description = "银行卡号", example = "6222021234567890123")
    private String bankCard;
    
    @NotBlank(message = "银行名称不能为空")
    @Schema(description = "银行名称", example = "中国工商银行")
    private String bankName;
    
    @NotBlank(message = "开户行不能为空")
    @Schema(description = "开户行", example = "中国工商银行北京分行")
    private String bankBranch;
}