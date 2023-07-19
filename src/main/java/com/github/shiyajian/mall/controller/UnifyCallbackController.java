package com.github.shiyajian.mall.controller;

import com.github.shiyajian.mall.channel.common.definition.ChannelCallbackHandler;
import com.github.shiyajian.mall.channel.common.definition.ChannelCodeEnum;
import com.github.shiyajian.mall.channel.common.definition.ChannelRequestParser;
import com.github.shiyajian.mall.channel.common.manager.ChannelCallbackHandlerManager;
import com.github.shiyajian.mall.channel.common.manager.ChannelRequestParserManager;
import com.github.shiyajian.mall.channel.common.scene.ChannelSceneEnum;
import com.github.shiyajian.mall.channel.common.scene.pay.CallbackPayRequest;
import com.github.shiyajian.mall.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shiyajian
 * create: 2023-07-19
 */
@RestController
@Slf4j
@RequestMapping("/api/callback")
public class UnifyCallbackController {

    @Autowired
    private PayService payService;

    @Autowired
    private ChannelCallbackHandlerManager channelCallbackHandlerManager;

    @Autowired
    private ChannelRequestParserManager channelRequestParserManager;


    @RequestMapping("/pay/{channelCode}/{bizNo}")
    public ResponseEntity<?> paySuccessCallback(HttpServletRequest request,
                                                @PathVariable(value = "channelCode") String channelCode,
                                                @PathVariable(value = "bizNo") String bizNo) {

        log.info("进入[" + channelCode + "]支付成功回调：bizNo：[" + bizNo + "] ");

        ChannelCodeEnum channelCodeEnum = ChannelCodeEnum.ofCode(channelCode);
        ChannelCallbackHandler handler = channelCallbackHandlerManager.findHandler(channelCodeEnum);

        return handler.run(() -> {
            // 找到 对应渠道 + 场景 的参数转换器
            ChannelRequestParser<CallbackPayRequest> parser = channelRequestParserManager.findParser(
                    channelCodeEnum, ChannelSceneEnum.PAY);
            // 将参数转换成统一模型
            CallbackPayRequest payRequest = parser.parse(request, bizNo);
            // 业务针对同一模型进行处理
            payService.paySuccess(payRequest);
        });
    }

    @RequestMapping("/withdraw/{channelCode}/{bizNo}")
    public ResponseEntity<?> withdrawSuccessCallback(HttpServletRequest request,
                                                     @PathVariable(value = "channelCode") String channelCode,
                                                     @PathVariable(value = "bizNo") String bizNo) {

        log.info("进入[" + channelCode + "]提现成功回调：bizNo：[" + bizNo + "] ");

        ChannelCodeEnum channelCodeEnum = ChannelCodeEnum.ofCode(channelCode);
        ChannelCallbackHandler handler = channelCallbackHandlerManager.findHandler(channelCodeEnum);

        return handler.run(() -> {
            // 找到 对应渠道 + 场景 的参数转换器
            ChannelRequestParser<CallbackPayRequest> parser = channelRequestParserManager.findParser(
                    channelCodeEnum, ChannelSceneEnum.PAY);
            // 将参数转换成统一模型
            CallbackPayRequest payRequest = parser.parse(request, bizNo);
            // 业务针对同一模型进行处理
            payService.paySuccess(payRequest);
        });
    }

}
