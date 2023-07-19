package com.github.shiyajian.mall.service;

import com.github.shiyajian.mall.channel.common.definition.ChannelCodeEnum;
import com.github.shiyajian.mall.channel.common.scene.pay.CallbackPayRequest;

/**
 * @author shiyajian
 * create: 2023-07-19
 */
public interface PayService {

    /**
     * 订单支付
     *
     * @param channelCode 支付渠道
     * @param args        支付单需要参数，这个是举例随便写了
     * @return 前端页面唤醒支付弹窗的参数
     */
    String pay(ChannelCodeEnum channelCode, Object args);

    /**
     * 支付成功后业务处理
     */
    void paySuccess(CallbackPayRequest request);

}
