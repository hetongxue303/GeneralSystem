package com.hetongxue.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 权限实体
 * @ClassNmae: Permission
 * @Author: 何同学
 * @DateTime: 2022-05-29 21:41
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("sys_permission")
public class Permission implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String label;
    private Long parentId;
    private String parentName;
    private String code;
    private Long orderNum;
    private String path;
    private String name;
    private String url;
    private Integer type;
    private String icon;
    private String remark;
    private boolean isDelete;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
