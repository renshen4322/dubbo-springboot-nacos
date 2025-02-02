package com.liyz.dubbo.common.base.cglib;

import com.github.pagehelper.PageInfo;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.liyz.dubbo.common.remote.page.Page;
import org.springframework.cglib.beans.BeanCopier;

import java.util.List;
import java.util.Objects;

/**
 * 注释:
 *
 * @author mark
 * @version 1.0.0
 * @date 2019/10/14 17:10
 */
public class PageInfoCopier<F, T> extends BaseBeanCopier<F, T> {

    private static final BeanCopier pageInfoCopier =
            BeanCopier.create(PageInfo.class, PageInfo.class, false);

    public static <F, T> PageInfo<T> transform(PageInfo<F> sourcePageInfo, Function<? super F, ? extends T> function) {
        List<T> targetList = Objects.nonNull(sourcePageInfo.getList()) ?
                Lists.transform(sourcePageInfo.getList(), function) :
                Lists.newArrayList();
        PageInfo<T> targetPageInfo = new PageInfo<>();
        pageInfoCopier.copy(sourcePageInfo, targetPageInfo, null);
        targetPageInfo.setList(targetList);
        return targetPageInfo;
    }

    public static <F, T> Page<T> transformPage(PageInfo<F> sourcePageInfo, Function<? super F, ? extends T> function) {
        List<T> targetList = Objects.nonNull(sourcePageInfo.getList()) ?
                Lists.transform(sourcePageInfo.getList(), function) :
                Lists.newArrayList();
        Page<T> page = new Page<>(targetList, sourcePageInfo.getTotal(), sourcePageInfo.getPages(), sourcePageInfo.getPageNum(), sourcePageInfo.getPageSize(), sourcePageInfo.isHasNextPage());
        return page;
    }
}
