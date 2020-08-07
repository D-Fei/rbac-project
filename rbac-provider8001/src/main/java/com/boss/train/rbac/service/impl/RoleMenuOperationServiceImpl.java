package com.boss.train.rbac.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.boss.train.rbac.dao.RoleMenuOperationDao;
import com.boss.train.rbac.entities.dto.RoleMenuOperationDTO;
import com.boss.train.rbac.entities.vo.RoleMenuOperationVO;
import com.boss.train.rbac.service.RoleMenuOperationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleMenuOperationServiceImpl implements RoleMenuOperationService {

    @Resource
    private RoleMenuOperationDao roleMenuOperationDao;

    @Resource
    private RoleMenuOperationDTO roleMenuOperationDTO;

    @Override
    public Integer createRMO(RoleMenuOperationVO roleMenuOperationVO) {
        BeanUtil.copyProperties(roleMenuOperationVO,roleMenuOperationDTO);
        return roleMenuOperationDao.createRMO(roleMenuOperationDTO);
    }

    @Override
    public Integer deleteRMO(Integer id) {
        return roleMenuOperationDao.deleteRMO(id);
    }

    @Override
    public Integer updateRMO(RoleMenuOperationVO roleMenuOperationVO) {
        BeanUtil.copyProperties(roleMenuOperationVO,roleMenuOperationDTO);
        return roleMenuOperationDao.updateRMO(roleMenuOperationDTO);
    }

    @Override
    public RoleMenuOperationDTO getRMO(Integer id) {
        BeanUtil.copyProperties(roleMenuOperationDao.getRMO(id),roleMenuOperationDTO);
        return roleMenuOperationDTO;
    }
}
