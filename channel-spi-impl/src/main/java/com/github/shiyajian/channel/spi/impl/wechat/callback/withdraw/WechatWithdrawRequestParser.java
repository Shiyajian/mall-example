package com.github.shiyajian.channel.spi.impl.wechat.callback.withdraw;

import com.github.shiyajian.channel.spi.api.callback.withdraw.CallbackWithdrawParser;
import com.github.shiyajian.channel.spi.api.callback.withdraw.CallbackWithdrawRequest;
import com.github.shiyajian.channel.spi.api.common.ChannelCodeEnum;
import com.github.shiyajian.channel.spi.impl.wechat.util.WechatUtil;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shiyajian
 * create: 2023-07-19
 */
@Component
public class WechatWithdrawRequestParser extends CallbackWithdrawParser {

    @Override
    public ChannelCodeEnum channel() {
        return ChannelCodeEnum.WECHAT;
    }

    @Override
    public CallbackWithdrawRequest parse(HttpServletRequest request, String bizNo) {
        CallbackWithdrawRequest callbackWithdrawRequest = new CallbackWithdrawRequest();
        WechatWithdrawBody wechatWithdrawBody = WechatUtil.decryptRequest(request, WechatWithdrawBody.class);
        // TODO 微信的模型转换成通用模型
        return callbackWithdrawRequest;
    }

}
