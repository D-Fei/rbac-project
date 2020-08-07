package com.boss.train.rbac.dao;

import com.boss.train.rbac.entities.dto.RoleDTO;
import com.boss.train.rbac.entities.po.RolePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleDao {

    public Integer createRole(RoleDTO roleDTO);

    public Integer deleteRole(@Param("id") Integer id);

    public Integer updateRole(RoleDTO roleDTO);

    public RolePO getRole(@Param("id") Integer id);

}
