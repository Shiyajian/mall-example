package com.github.shiyajian.mall.repository;

import com.github.shiyajian.mall.channel.common.definition.Channel;
import com.github.shiyajian.mall.domain.PayOrder;
import com.github.shiyajian.mall.domain.WithdrawRecord;

/**
 * @author shiyajian
 * create: 2023-07-19
 */
public interface ChannelRepository extends Channel {

    void submitPay(PayOrder payOrder);

    void submitWithdraw(WithdrawRecord withdrawRecord);
}
