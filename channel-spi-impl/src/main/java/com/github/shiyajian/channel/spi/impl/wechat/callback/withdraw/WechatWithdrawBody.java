package com.github.shiyajian.channel.spi.impl.wechat.callback.withdraw;

import lombok.Data;

/**
 * @author shiyajian
 * create: 2023-07-20
 */
@Data
public class WechatWithdrawBody {
    private String wechatNo;
    private String wechatStatus;
}
