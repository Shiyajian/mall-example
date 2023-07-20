package com.github.shiyajian.mall.service;


import com.github.shiyajian.channel.spi.api.callback.withdraw.CallbackWithdrawRequest;
import com.github.shiyajian.channel.spi.api.common.ChannelCodeEnum;

/**
 * @author shiyajian
 * create: 2023-07-19
 */
public interface WithdrawService {

    /**
     * 提现成功后业务处理
     */
    boolean withdrawSuccess(CallbackWithdrawRequest request);

    boolean withdraw(ChannelCodeEnum channelCodeEnum, Object params);
}
