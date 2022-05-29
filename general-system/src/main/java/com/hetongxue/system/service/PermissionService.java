package com.hetongxue.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hetongxue.system.domain.Permission;

import java.util.List;

/**
 * @Description: 权限服务
 * @InterfaceNmae: PermissionService
 * @Author: 何同学
 * @DateTime: 2022-05-29 21:46
 **/
public interface PermissionService extends IService<Permission> {


    /**
     * 获取所有权限信息
     */
    List<Permission> getPermissionAll();

}
