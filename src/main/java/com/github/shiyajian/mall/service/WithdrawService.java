package com.github.shiyajian.mall.service;

import com.github.shiyajian.mall.channel.common.definition.ChannelCodeEnum;
import com.github.shiyajian.mall.channel.common.scene.withdraw.CallbackWithdrawRequest;

/**
 * @author shiyajian
 * create: 2023-07-19
 */
public interface WithdrawService {

    /**
     * 提现成功后业务处理
     */
    void withdrawSuccess(CallbackWithdrawRequest request);

    void withdraw(ChannelCodeEnum channelCodeEnum, Object params);
}
