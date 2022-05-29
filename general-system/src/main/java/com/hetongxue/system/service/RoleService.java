package com.hetongxue.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hetongxue.system.domain.Role;

import java.util.List;

/**
 * @Description: 角色服务
 * @InterfaceNmae: RoleService
 * @Author: 何同学
 * @DateTime: 2022-05-29 21:25
 **/
public interface RoleService extends IService<Role> {


    /**
     * 获取所有角色信息
     */
    List<Role> getRoleAll();

}
