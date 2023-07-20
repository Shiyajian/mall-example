package com.github.shiyajian.channel.spi.api.callback;

import com.github.shiyajian.channel.spi.api.common.Channel;
import com.github.shiyajian.channel.spi.api.common.Scene;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shiyajian
 * create: 2023-03-02
 */
public interface ChannelCallbackRequestParser<T> extends Channel, Scene {


    /**
     * 将渠道商的数据转换成我们自己的数据
     */
    T parse(HttpServletRequest request, String bizNo);


}
