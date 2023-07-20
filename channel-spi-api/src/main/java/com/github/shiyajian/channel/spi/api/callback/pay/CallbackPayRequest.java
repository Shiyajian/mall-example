package com.github.shiyajian.channel.spi.api.callback.pay;

import lombok.Data;

import java.util.Date;

/**
 * @author shiyajian
 * create: 2023-07-19
 */
@Data
public class CallbackPayRequest {

    private String orderNo;

    private Date successTime;
}
