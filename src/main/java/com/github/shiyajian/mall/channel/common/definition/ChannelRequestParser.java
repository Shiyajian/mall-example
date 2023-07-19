package com.github.shiyajian.mall.channel.common.definition;

import com.github.shiyajian.mall.channel.common.scene.CallbackBaseRequest;
import com.github.shiyajian.mall.channel.common.scene.ChannelSceneEnum;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shiyajian
 * create: 2023-03-02
 */
@Slf4j
public abstract class ChannelRequestParser<T extends CallbackBaseRequest> implements Channel {


    /**
     * 业务场景
     */
    public abstract ChannelSceneEnum scene();


    /**
     * 将渠道商的数据转换成我们自己的数据
     */
    public abstract T parse(HttpServletRequest request, String bizNo);


}
