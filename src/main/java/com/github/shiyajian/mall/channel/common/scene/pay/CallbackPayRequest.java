package com.github.shiyajian.mall.channel.common.scene.pay;

import com.github.shiyajian.mall.channel.common.scene.CallbackBaseRequest;
import lombok.Data;

import java.util.Date;

/**
 * @author shiyajian
 * create: 2023-07-19
 */
@Data
public class CallbackPayRequest extends CallbackBaseRequest {

    private String orderNo;

    private Date successTime;
}
