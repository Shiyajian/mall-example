package com.github.shiyajian.mall.channel.wechat;

import com.github.shiyajian.mall.channel.common.definition.ChannelCodeEnum;
import com.github.shiyajian.mall.domain.PayOrder;
import com.github.shiyajian.mall.domain.WithdrawRecord;
import com.github.shiyajian.mall.repository.ChannelRepository;
import org.springframework.stereotype.Component;

/**
 * @author shiyajian
 * create: 2023-07-19
 */
@Component
public class WechatChannelRepository implements ChannelRepository {

    @Override
    public ChannelCodeEnum channel() {
        return ChannelCodeEnum.WECHAT;
    }

    @Override
    public void submitPay(PayOrder payOrder) {

        // 1、将业务的模型 转换成微信模型；

        // 2、微信模型发起微信请求调用；

        // 3、返回微信支付成功后参数
        payOrder.setThirdOrderNo("xxx微信返回的");
        payOrder.setPayParams("微信返回的");
    }

    @Override
    public void submitWithdraw(WithdrawRecord withdrawRecord) {

    }
}
