package com.liyz.dubbo.common.security.annotation;

import java.lang.annotation.*;

/**
 * 注释:匿名访问注解
 *
 * @author mark
 * @version 1.0.0
 * @date 2020/8/17 17:42
 */
@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Anonymous {

}
