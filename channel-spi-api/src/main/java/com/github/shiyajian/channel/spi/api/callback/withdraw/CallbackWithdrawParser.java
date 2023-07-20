package com.github.shiyajian.channel.spi.api.callback.withdraw;

import com.github.shiyajian.channel.spi.api.callback.ChannelCallbackRequestParser;
import com.github.shiyajian.channel.spi.api.common.ChannelCallbackSceneEnum;

/**
 * @author shiyajian
 * create: 2023-07-19
 */
public abstract class CallbackWithdrawParser implements ChannelCallbackRequestParser<CallbackWithdrawRequest> {

    @Override
    public ChannelCallbackSceneEnum scene() {
        return ChannelCallbackSceneEnum.WITHDRAW_CALLBACK;
    }
}
