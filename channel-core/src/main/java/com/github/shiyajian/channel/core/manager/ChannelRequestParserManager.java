package com.github.shiyajian.channel.core.manager;

import com.github.shiyajian.channel.spi.api.callback.ChannelCallbackRequestParser;
import com.github.shiyajian.channel.spi.api.common.ChannelCallbackSceneEnum;
import com.github.shiyajian.channel.spi.api.common.ChannelCodeEnum;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author shiyajian
 * create: 2023-03-02
 */
@Component
@Slf4j
public class ChannelRequestParserManager implements InitializingBean {

    private final Table<ChannelCodeEnum, ChannelCallbackSceneEnum, ChannelCallbackRequestParser<?>> parserTable = HashBasedTable.create();
    @Autowired
    private List<ChannelCallbackRequestParser<?>> parserList;

    @SuppressWarnings("unchecked")
    public <T> T parse(ChannelCodeEnum channelCode, ChannelCallbackSceneEnum scene, HttpServletRequest request, String bizNo) {
        ChannelCallbackRequestParser<?> channelRequestParser = parserTable.get(channelCode, scene);
        if (channelRequestParser == null) {
            throw new RuntimeException(String.format("暂时不支持渠道：「%s」，类型：「%s」的回调处理", channelCode.getCode(), scene.getCode()));
        }
        // 1、记录http请求日志，略
        // 2、通过不同场景的转换器，转换出参数，并返回
        return (T) channelRequestParser.parse(request, bizNo);
    }

    @Override
    public void afterPropertiesSet() {
        parserList.forEach(e -> {
            parserTable.put(e.channel(), e.scene(), e);
        });
    }
}
