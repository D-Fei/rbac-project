package com.boss.train.rbac.service;

import com.boss.train.rbac.entities.dto.RoleMenuOperationDTO;
import com.boss.train.rbac.entities.vo.RoleMenuOperationVO;

public interface RoleMenuOperationService {

    public Integer createRMO(RoleMenuOperationVO roleMenuOperationVO);

    public Integer deleteRMO(Integer id);

    public Integer updateRMO(RoleMenuOperationVO roleMenuOperationVO);

    public RoleMenuOperationDTO getRMO(Integer id);

}
