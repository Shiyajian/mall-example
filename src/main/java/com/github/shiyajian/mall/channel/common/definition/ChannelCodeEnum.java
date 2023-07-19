package com.github.shiyajian.mall.channel.common.definition;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;


@Getter
@AllArgsConstructor
public enum ChannelCodeEnum {

    WECHAT("WECHAT", "微信支付"),
    ALIPAY("ALIPAY", "支付宝支付");

    private final String code;
    private final String desc;

    public static ChannelCodeEnum ofCode(String code) {
        return Arrays.stream(ChannelCodeEnum.class.getEnumConstants())
                .filter(e -> Objects.equals(e.getCode(), code))
                .findFirst()
                .orElse(null);
    }
}
