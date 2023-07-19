package com.github.shiyajian.mall.channel.common.scene;

import com.github.shiyajian.mall.channel.common.scene.pay.CallbackPayRequest;
import com.github.shiyajian.mall.channel.common.scene.withdraw.CallbackWithdrawRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;


@Getter
@AllArgsConstructor
public enum ChannelSceneEnum {

    PAY("PAY", "支付成功回调场景", CallbackPayRequest.class),
    WITHDRAW("WITHDRAW", "提现成功回调场景", CallbackWithdrawRequest.class),
    ;

    private final String code;
    private final String desc;
    private final Class<? extends CallbackBaseRequest> clazz;


    public static ChannelSceneEnum ofCode(String code) {
        return Arrays.stream(ChannelSceneEnum.class.getEnumConstants())
                .filter(e -> Objects.equals(e.getCode(), code))
                .findFirst()
                .orElse(null);
    }
}
