package com.github.shiyajian.channel.core.manager;

import com.github.shiyajian.channel.spi.api.call.ChannelCaller;
import com.github.shiyajian.channel.spi.api.common.ChannelCodeEnum;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author shiyajian
 * create: 2023-03-02
 */
@Component
@Slf4j
public class ChannelCallerManager implements InitializingBean {

    private final Map<ChannelCodeEnum, ChannelCaller> repositoryMap = Maps.newConcurrentMap();
    @Autowired
    private List<ChannelCaller> channels;

    public ChannelCaller of(ChannelCodeEnum channel) {
        ChannelCaller channelCaller = repositoryMap.get(channel);
        if (channelCaller == null) {
            throw new IllegalStateException("对应的渠道「%s」不存在查询类仓储层");
        }
        return channelCaller;
    }



    @Override
    public void afterPropertiesSet() {
        channels.forEach(e -> repositoryMap.put(e.channel(), e));
    }
}
