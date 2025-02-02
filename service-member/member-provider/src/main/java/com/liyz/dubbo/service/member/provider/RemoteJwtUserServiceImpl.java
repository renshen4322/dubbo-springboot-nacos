package com.liyz.dubbo.service.member.provider;

import com.liyz.dubbo.common.base.request.annotation.Logs;
import com.liyz.dubbo.common.base.util.CommonCloneUtil;
import com.liyz.dubbo.common.remote.bo.JwtUserBO;
import com.liyz.dubbo.common.remote.service.RemoteJwtUserService;
import com.liyz.dubbo.service.member.model.UserInfoDO;
import com.liyz.dubbo.service.member.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 注释:
 *
 * @author mark
 * @version 1.0.0
 * @date 2020/7/3 13:27
 */
@Slf4j
@DubboService(version = "1.0.0", group = "member")
public class RemoteJwtUserServiceImpl implements RemoteJwtUserService {

    @Autowired
    UserInfoService userInfoService;

    @Logs
    @Override
    public JwtUserBO getByLoginName(String loginName) {
        if (StringUtils.isBlank(loginName)) {
            return null;
        }
        UserInfoDO userInfoDO = userInfoService.getByLoginName(loginName);
        return CommonCloneUtil.objectClone(userInfoDO, JwtUserBO.class);
    }
}
