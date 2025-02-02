package com.liyz.dubbo.common.remote.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 注释:
 *
 * @author mark
 * @version 1.0.0
 * @date 2020/8/17 11:28
 */
@Getter
@Setter
public class GrantedAuthorityBO implements Serializable {
    private static final long serialVersionUID = 5933193179821183888L;

    private Integer roleId;

    private Integer permissionId;

    private String permissionUrl;

    private String method;
}
