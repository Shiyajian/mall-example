package com.github.shiyajian.mall.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author shiyajian
 * create: 2023-07-19
 */
@Data
public class PayOrder {

    private String orderNo;

    private BigDecimal amount;

    /**
     * 三方支付单号
     */
    private String thirdOrderNo;

    /**
     * 唤起前端支付组件的参数
     */
    private String payParams;
}
