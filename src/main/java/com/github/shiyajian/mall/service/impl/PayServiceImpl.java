package com.github.shiyajian.mall.service.impl;

import com.github.shiyajian.mall.channel.common.definition.ChannelCodeEnum;
import com.github.shiyajian.mall.channel.common.manager.ChannelRepositoryManager;
import com.github.shiyajian.mall.channel.common.scene.pay.CallbackPayRequest;
import com.github.shiyajian.mall.domain.PayOrder;
import com.github.shiyajian.mall.repository.ChannelRepository;
import com.github.shiyajian.mall.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author shiyajian
 * create: 2023-07-19
 */
@Component
public class PayServiceImpl implements PayService {

    @Autowired
    private ChannelRepositoryManager channelRepositoryManager;

    @Override
    public String pay(ChannelCodeEnum channelCode, Object args) {
        // 1、创建支付单；
        PayOrder payOrder = new PayOrder();
        // 2、支付单入库；

        // 3、根据不同支付渠道，调用三方的支付单创建
        ChannelRepository channelRepository = channelRepositoryManager.of(channelCode);
        channelRepository.submitPay(payOrder);

        // 4、更新三方订单号入库

        // 5、返回前端唤醒参数
        return payOrder.getPayParams();
    }

    @Override
    public void paySuccess(CallbackPayRequest request) {
        // 1、根据订单号查询自己订单；

        // 2、订单修改为已支付完成；

        // 3、发送订单支付成功消息
    }
}
