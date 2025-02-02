package com.liyz.dubbo.common.socket.util;

import com.liyz.dubbo.common.base.util.SpringContextUtil;
import com.liyz.dubbo.common.socket.service.biz.BizService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * 注释:BizDataUtil
 *
 * @author mark
 * @version 1.0.0
 * @date 2020/7/24 15:39
 */
@Slf4j
@Component
public final class BizDataUtil implements ApplicationContextAware {

    @Autowired
    SpringContextUtil springContextUtil;

    private static Map<String, BizService> holder = new HashMap<>();

    @PostConstruct
    public void init() {
        Map<String, BizService> beanMaps = SpringContextUtil.getBeansOfType(BizService.class);
        if (!CollectionUtils.isEmpty(beanMaps)) {
            for (BizService bizService : beanMaps.values()) {
                holder.put(bizService.getDataType().getDataType(), bizService);
            }
        }
        log.info("BizService bean list , size : {}", CollectionUtils.isEmpty(holder) ? 0 : holder.size());
    }

    public static BizService getService(String dataType) {
        if (CollectionUtils.isEmpty(holder)) {
            return null;
        }
        return holder.get(dataType);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
