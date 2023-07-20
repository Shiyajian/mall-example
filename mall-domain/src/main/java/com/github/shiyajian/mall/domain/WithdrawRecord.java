package com.github.shiyajian.mall.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author shiyajian
 * create: 2023-07-19
 */
@Data
public class WithdrawRecord {

    private String merchantNo;

    private String walletNo;

    private BigDecimal amount;
}
