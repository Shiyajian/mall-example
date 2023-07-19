package com.github.shiyajian.mall.channel.common.scene.pay;

import com.github.shiyajian.mall.channel.common.definition.ChannelRequestParser;
import com.github.shiyajian.mall.channel.common.scene.ChannelSceneEnum;

/**
 * @author shiyajian
 * create: 2023-07-19
 */
public abstract class CallbackPayParser extends ChannelRequestParser<CallbackPayRequest> {

    @Override
    public ChannelSceneEnum scene() {
        return ChannelSceneEnum.PAY;
    }
}
