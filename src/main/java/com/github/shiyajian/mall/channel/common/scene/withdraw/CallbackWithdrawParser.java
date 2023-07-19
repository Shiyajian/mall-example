package com.github.shiyajian.mall.channel.common.scene.withdraw;

import com.github.shiyajian.mall.channel.common.definition.ChannelRequestParser;
import com.github.shiyajian.mall.channel.common.scene.ChannelSceneEnum;

/**
 * @author shiyajian
 * create: 2023-07-19
 */
public abstract class CallbackWithdrawParser extends ChannelRequestParser<CallbackWithdrawRequest> {

    @Override
    public ChannelSceneEnum scene() {
        return ChannelSceneEnum.WITHDRAW;
    }
}
