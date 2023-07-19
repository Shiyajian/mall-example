package com.github.shiyajian.mall.channel.wechat.scene;

import com.github.shiyajian.mall.channel.common.definition.ChannelCodeEnum;
import com.github.shiyajian.mall.channel.common.scene.pay.CallbackPayParser;
import com.github.shiyajian.mall.channel.common.scene.pay.CallbackPayRequest;
import com.github.shiyajian.mall.channel.wechat.WechatUtil;
import lombok.Data;
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
        WechatPayBody wechatPayBody = WechatUtil.decrypt(request, WechatPayBody.class);
        // TODO 微信的模型转换成通用模型
        return callbackPayRequest;
    }

    @Data
    private static class WechatPayBody {
        private String wechatNo;
        private String wechatStatus;
    }
}
