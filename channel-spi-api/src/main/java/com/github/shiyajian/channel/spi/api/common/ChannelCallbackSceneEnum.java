package com.github.shiyajian.channel.spi.api.common;

import com.github.shiyajian.channel.spi.api.callback.pay.CallbackPayRequest;
import com.github.shiyajian.channel.spi.api.callback.withdraw.CallbackWithdrawRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;


@Getter
@AllArgsConstructor
public enum ChannelCallbackSceneEnum {

    PAY_CALLBACK("PAY_CALLBACK", "支付成功回调场景", CallbackPayRequest.class),
    WITHDRAW_CALLBACK("WITHDRAW_CALLBACK", "提现成功回调场景", CallbackWithdrawRequest.class),
    ;

    private final String code;
    private final String desc;
    private final Class<?> clazz;


    public static ChannelCallbackSceneEnum ofCode(String code) {
        return Arrays.stream(ChannelCallbackSceneEnum.class.getEnumConstants())
                .filter(e -> Objects.equals(e.getCode(), code))
                .findFirst()
                .orElse(null);
    }
}
