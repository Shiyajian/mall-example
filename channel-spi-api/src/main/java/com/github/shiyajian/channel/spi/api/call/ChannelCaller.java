package com.github.shiyajian.channel.spi.api.call;

import com.github.shiyajian.channel.spi.api.common.Channel;
import com.github.shiyajian.mall.domain.PayOrder;
import com.github.shiyajian.mall.domain.WithdrawRecord;

/**
 * @author shiyajian
 * create: 2023-07-19
 */
public interface ChannelCaller extends Channel {

    void submitPay(PayOrder payOrder);

    void submitWithdraw(WithdrawRecord withdrawRecord);
}
