package com.liyz.dubbo.common.security.core;

import lombok.Getter;
import org.springframework.security.access.ConfigAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * 注释:
 *
 * @author mark
 * @version 1.0.0
 * @date 2020/8/18 16:58
 */
public class ConfigAttributeImpl implements ConfigAttribute {

    @Getter
    private final HttpServletRequest httpServletRequest;

    public ConfigAttributeImpl(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    @Override
    public String getAttribute() {
        return null;
    }
}
