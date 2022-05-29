package com.hetongxue.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hetongxue.system.domain.Permission;
import com.hetongxue.system.mapper.PermissionMapper;
import com.hetongxue.system.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 权限服务实现
 * @ClassNmae: PermissionServiceImpl
 * @Author: 何同学
 * @DateTime: 2022-05-29 21:47
 **/
@Service
@Transactional
@RequiredArgsConstructor
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    private final PermissionMapper permissionMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Permission> getPermissionAll() {
        return permissionMapper.selectList(null);
    }
}
