package com.github.shiyajian.mall.channel.wechat.scene;

import com.github.shiyajian.mall.channel.common.definition.ChannelCodeEnum;
import com.github.shiyajian.mall.channel.common.scene.withdraw.CallbackWithdrawParser;
import com.github.shiyajian.mall.channel.common.scene.withdraw.CallbackWithdrawRequest;
import com.github.shiyajian.mall.channel.wechat.WechatUtil;
import lombok.Data;
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
        WechatWithdrawBody wechatWithdrawBody = WechatUtil.decrypt(request, WechatWithdrawBody.class);
        // TODO 微信的模型转换成通用模型
        return callbackWithdrawRequest;
    }

    @Data
    private static class WechatWithdrawBody {
        private String wechatNo;
        private String wechatStatus;
    }
}
