package com.github.shiyajian.mall.channel.common.manager;

import com.github.shiyajian.mall.channel.common.definition.ChannelCodeEnum;
import com.github.shiyajian.mall.repository.ChannelRepository;
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
public class ChannelRepositoryManager implements InitializingBean {

    private final Map<ChannelCodeEnum, ChannelRepository> repositoryMap = Maps.newConcurrentMap();
    @Autowired
    private List<ChannelRepository> channels;

    public ChannelRepository of(ChannelCodeEnum channel) {
        ChannelRepository channelQueryRepository = repositoryMap.get(channel);
        if (channelQueryRepository == null) {
            throw new IllegalStateException("对应的渠道「%s」不存在查询类仓储层");
        }
        return channelQueryRepository;
    }

    @Override
    public void afterPropertiesSet() {
        channels.forEach(e -> repositoryMap.put(e.channel(), e));
    }
}
