package com.github.shiyajian.channel.spi.impl.wechat.callback.pay;

import lombok.Data;

/**
 * @author shiyajian
 * create: 2023-07-20
 */
@Data
public class WechatPayBody {
    private String wechatNo;
    private String wechatStatus;
}
