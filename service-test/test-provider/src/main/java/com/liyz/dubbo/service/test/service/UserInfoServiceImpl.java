package com.liyz.dubbo.service.test.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liyz.dubbo.service.test.dao.UserInfoMapper;
import com.liyz.dubbo.service.test.model.UserInfoDO;
import org.springframework.stereotype.Service;

/**
 * 注释:
 *
 * @author mark
 * @version 1.0.0
 * @date 2021/1/29 16:56
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfoDO> {

    public Page<UserInfoDO> page(Integer pageNum, Integer pageSize) {
        Page<UserInfoDO> page = super.page(
                new Page<>(pageNum, pageSize),
                Wrappers.<UserInfoDO>lambdaQuery().orderByAsc(UserInfoDO::getUserId)
        );
        return page;
    }

    public static void main(String[] args) {
        int cap = 16;
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        System.out.println(n +1);
    }
}
