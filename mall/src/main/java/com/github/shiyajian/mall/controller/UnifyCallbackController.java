package com.github.shiyajian.mall.controller;

import com.github.shiyajian.channel.core.manager.ChannelCallbackManager;
import com.github.shiyajian.channel.core.manager.ChannelRequestParserManager;
import com.github.shiyajian.channel.spi.api.callback.pay.CallbackPayRequest;
import com.github.shiyajian.channel.spi.api.callback.withdraw.CallbackWithdrawRequest;
import com.github.shiyajian.channel.spi.api.common.ChannelCallbackSceneEnum;
import com.github.shiyajian.channel.spi.api.common.ChannelCodeEnum;
import com.github.shiyajian.mall.service.PayService;
import com.github.shiyajian.mall.service.WithdrawService;
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
    private WithdrawService withdrawService;

    @Autowired
    private ChannelCallbackManager channelCallbackHandlerManager;

    @Autowired
    private ChannelRequestParserManager channelRequestParserManager;


    @RequestMapping("/pay/{channelCode}/{bizNo}")
    public ResponseEntity<?> paySuccessCallback(HttpServletRequest request,
                                                @PathVariable(value = "channelCode") String channelCode,
                                                @PathVariable(value = "bizNo") String bizNo) {

        log.info("进入[" + channelCode + "]支付成功回调：bizNo：[" + bizNo + "] ");

        ChannelCodeEnum channelCodeEnum = ChannelCodeEnum.ofCode(channelCode);
        return channelCallbackHandlerManager.run(channelCodeEnum, () -> {
            CallbackPayRequest payRequest = channelRequestParserManager.parse(channelCodeEnum, ChannelCallbackSceneEnum.PAY_CALLBACK, request, bizNo);
            return payService.paySuccess(payRequest);
        });
    }

    @RequestMapping("/withdraw/{channelCode}/{bizNo}")
    public ResponseEntity<?> withdrawSuccessCallback(HttpServletRequest request,
                                                     @PathVariable(value = "channelCode") String channelCode,
                                                     @PathVariable(value = "bizNo") String bizNo) {

        log.info("进入[" + channelCode + "]提现成功回调：bizNo：[" + bizNo + "] ");

        ChannelCodeEnum channelCodeEnum = ChannelCodeEnum.ofCode(channelCode);
        return channelCallbackHandlerManager.run(channelCodeEnum, () -> {
            CallbackWithdrawRequest withdrawRequest = channelRequestParserManager.parse(channelCodeEnum, ChannelCallbackSceneEnum.WITHDRAW_CALLBACK, request, bizNo);
            return withdrawService.withdrawSuccess(withdrawRequest);
        });

    }

}
