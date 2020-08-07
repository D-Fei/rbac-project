package com.boss.train.rbac.service;

import com.boss.train.rbac.entities.dto.RoleDTO;
import com.boss.train.rbac.entities.vo.RoleVO;
import org.apache.ibatis.annotations.Param;

public interface RoleService {

    public Integer createRole(RoleVO roleVO);

    public Integer deleteRole(@Param("id") Integer id);

    public Integer updateRole(RoleVO roleVO);

    public RoleDTO getRole(@Param("id") Integer id);

}
