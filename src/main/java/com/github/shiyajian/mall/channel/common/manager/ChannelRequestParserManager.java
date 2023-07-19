package com.github.shiyajian.mall.channel.common.manager;

import com.github.shiyajian.mall.channel.common.definition.ChannelCodeEnum;
import com.github.shiyajian.mall.channel.common.definition.ChannelRequestParser;
import com.github.shiyajian.mall.channel.common.scene.CallbackBaseRequest;
import com.github.shiyajian.mall.channel.common.scene.ChannelSceneEnum;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author shiyajian
 * create: 2023-03-02
 */
@Component
@Slf4j
public class ChannelRequestParserManager implements InitializingBean {

    private final Table<ChannelCodeEnum, ChannelSceneEnum, ChannelRequestParser<?>> parserTable = HashBasedTable.create();
    @Autowired
    private List<ChannelRequestParser<?>> parserList;

    @SuppressWarnings("unchecked")
    public <T extends CallbackBaseRequest> ChannelRequestParser<T> findParser(ChannelCodeEnum channelCode, ChannelSceneEnum scene) {
        ChannelRequestParser<?> channelRequestParser = parserTable.get(channelCode, scene);
        if (channelRequestParser == null) {
            throw new RuntimeException(String.format("暂时不支持渠道：「%s」，类型：「%s」的回调处理", channelCode.getCode(), scene.getCode()));
        }
        return (ChannelRequestParser<T>) channelRequestParser;
    }

    @Override
    public void afterPropertiesSet() {
        parserList.forEach(e -> {
            parserTable.put(e.channel(), e.scene(), e);
        });
    }
}
