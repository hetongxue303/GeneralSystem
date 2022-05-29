package com.hetongxue.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Description: 角色权限
 * @ClassNmae: RolePermission
 * @Author: 何同学
 * @DateTime: 2022-05-29 21:56
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("sys_role_permission")
public class RolePermission implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;
    private Long roleId;
    private Long permissionId;

}
