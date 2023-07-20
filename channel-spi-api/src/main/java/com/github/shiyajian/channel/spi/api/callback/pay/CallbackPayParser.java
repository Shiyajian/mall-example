package com.github.shiyajian.channel.spi.api.callback.pay;

import com.github.shiyajian.channel.spi.api.callback.ChannelCallbackRequestParser;
import com.github.shiyajian.channel.spi.api.common.ChannelCallbackSceneEnum;

/**
 * @author shiyajian
 * create: 2023-07-19
 */
public abstract class CallbackPayParser implements ChannelCallbackRequestParser<CallbackPayRequest> {

    @Override
    public ChannelCallbackSceneEnum scene() {
        return ChannelCallbackSceneEnum.PAY_CALLBACK;
    }

}
