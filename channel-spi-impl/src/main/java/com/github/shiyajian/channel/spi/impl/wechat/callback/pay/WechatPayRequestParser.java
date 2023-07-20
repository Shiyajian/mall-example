package com.github.shiyajian.channel.spi.impl.wechat.callback.pay;

import com.github.shiyajian.channel.spi.api.callback.pay.CallbackPayParser;
import com.github.shiyajian.channel.spi.api.callback.pay.CallbackPayRequest;
import com.github.shiyajian.channel.spi.api.common.ChannelCodeEnum;
import com.github.shiyajian.channel.spi.impl.wechat.util.WechatUtil;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


/**
 * @author shiyajian
 * create: 2023-07-19
 */
@Component
public class WechatPayRequestParser extends CallbackPayParser {


    @Override
    public ChannelCodeEnum channel() {
        return ChannelCodeEnum.WECHAT;
    }

    @Override
    public CallbackPayRequest parse(HttpServletRequest request, String bizNo) {
        CallbackPayRequest callbackPayRequest = new CallbackPayRequest();
        WechatPayBody wechatPayBody = WechatUtil.decryptRequest(request, WechatPayBody.class);
        // TODO 微信的模型转换成通用模型
        return callbackPayRequest;
    }

}
