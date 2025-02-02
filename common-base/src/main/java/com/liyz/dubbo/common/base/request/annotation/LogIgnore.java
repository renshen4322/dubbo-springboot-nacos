package com.liyz.dubbo.common.base.request.annotation;

import java.lang.annotation.*;

/**
 * 注释:参数忽略注解
 *
 * @author mark
 * @version 1.0.0
 * @date 2020/8/5 16:31
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface LogIgnore {
}
