package com.liyz.dubbo.api.web.controller.member;

import com.liyz.dubbo.api.web.vo.member.UserInfoVO;
import com.liyz.dubbo.common.base.request.annotation.LogIgnore;
import com.liyz.dubbo.common.base.request.annotation.Logs;
import com.liyz.dubbo.common.base.result.Result;
import com.liyz.dubbo.common.base.util.CommonCloneUtil;
import com.liyz.dubbo.common.controller.resolver.annotation.LoginUser;
import com.liyz.dubbo.common.remote.bo.JwtUserBO;
import com.liyz.dubbo.service.member.remote.RemoteUserInfoService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Objects;

/**
 * 注释:
 *
 * @author mark
 * @version 1.0.0
 * @date 2020/1/6 14:31
 */
@Api(value = "用户信息", tags = "用户信息")
@ApiResponses(value = {
        @ApiResponse(code = 0, message = "成功"),
        @ApiResponse(code = 1, message = "失败"),
        @ApiResponse(code = 401, message = "暂无授权"),
        @ApiResponse(code = 404, message = "找不到资源"),
        @ApiResponse(code = 500, message = "服务器内部错误")
})
@Slf4j
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @DubboReference(version = "1.0.0", timeout = 100000)
    RemoteUserInfoService remoteUserInfoService;

    @Logs
    @ApiImplicitParam(name = "Authorization", value = "认证token", required = true, dataType = "String",
            paramType = "header")
    @ApiOperation(value = "获取登陆的用户信息", notes = "获取登陆的用户信息")
    @GetMapping("/info")
    public Result<UserInfoVO> info(@ApiIgnore @LoginUser JwtUserBO jwtUserBO) {
        return Result.success(CommonCloneUtil.objectClone(jwtUserBO, UserInfoVO.class));
    }

    @Logs
    @ApiOperation(value = "获取登陆的用户ID", notes = "获取登陆的用户ID")
    @GetMapping("/id")
    @ApiImplicitParam(name = "Authorization", value = "认证token", required = true, dataType = "String",
            paramType = "header")
    public Result<Long> id(@LogIgnore @ApiIgnore @LoginUser JwtUserBO jwtUserBO) {
        return Result.success(Objects.isNull(jwtUserBO) ? null : jwtUserBO.getUserId());
    }

    @Logs
    @ApiOperation(value = "test", notes = "test")
    @GetMapping("/ids")
    @ApiImplicitParam(name = "Authorization", value = "认证token", required = true, dataType = "String",
            paramType = "header")
    public Result<List<String>> id(@LogIgnore @ApiIgnore @LoginUser JwtUserBO jwtUserBO, @RequestParam(value = "ids") List<String> ids) {
        return Result.success(ids);
    }
}
