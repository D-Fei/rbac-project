package com.boss.train.rbac.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.boss.train.rbac.dao.RoleDao;
import com.boss.train.rbac.entities.dto.RoleDTO;
import com.boss.train.rbac.entities.vo.RoleVO;
import com.boss.train.rbac.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;

    @Resource
    private RoleDTO roleDTO;

    @Override
    public Integer createRole(RoleVO roleVO) {
        BeanUtil.copyProperties(roleVO,roleDTO);
        return roleDao.createRole(roleDTO);
    }

    @Override
    public Integer deleteRole(Integer id) {
        return roleDao.deleteRole(id);
    }

    @Override
    public Integer updateRole(RoleVO roleVO) {
        BeanUtil.copyProperties(roleVO,roleDTO);
        return roleDao.updateRole(roleDTO);
    }

    @Override
    public RoleDTO getRole(Integer id) {
        BeanUtil.copyProperties(roleDao.getRole(id),roleDTO);
        return roleDTO;
    }
}
