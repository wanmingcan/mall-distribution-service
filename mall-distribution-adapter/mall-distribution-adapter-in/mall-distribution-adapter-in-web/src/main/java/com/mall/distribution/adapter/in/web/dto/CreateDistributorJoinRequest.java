package com.mall.distribution.adapter.in.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建分销商申请请求
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "创建分销商申请请求")
public class CreateDistributorJoinRequest {
    
    @NotNull(message = "用户ID不能为空")
    @Schema(description = "用户ID", example = "1")
    private Long userId;
    
    @NotBlank(message = "申请人姓名不能为空")
    @Schema(description = "申请人姓名", example = "张三")
    private String applicantName;
    
    @NotBlank(message = "手机号不能为空")
    @Schema(description = "手机号", example = "13800138000")
    private String phone;
    
    @NotBlank(message = "身份证号不能为空")
    @Schema(description = "身份证号", example = "110101199001011234")
    private String idCard;
    
    @NotBlank(message = "身份证正面照不能为空")
    @Schema(description = "身份证正面照", example = "http://example.com/id_front.jpg")
    private String idCardFront;
    
    @NotBlank(message = "身份证反面照不能为空")
    @Schema(description = "身份证反面照", example = "http://example.com/id_back.jpg")
    private String idCardBack;
    
    @NotBlank(message = "银行卡号不能为空")
    @Schema(description = "银行卡号", example = "6222021234567890123")
    private String bankCard;
    
    @NotBlank(message = "银行名称不能为空")
    @Schema(description = "银行名称", example = "中国工商银行")
    private String bankName;
    
    @NotBlank(message = "开户行不能为空")
    @Schema(description = "开户行", example = "中国工商银行北京分行")
    private String bankBranch;
    
    @Schema(description = "申请理由", example = "希望成为分销商")
    private String reason;
}