package com.boss.train.rbac.dao;

import com.boss.train.rbac.entities.dto.RoleMenuOperationDTO;
import com.boss.train.rbac.entities.po.RoleMenuOperationPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleMenuOperationDao {

    public Integer createRMO(RoleMenuOperationDTO roleMenuOperationDTO);

    public Integer deleteRMO(@Param("id") Integer id);

    public Integer updateRMO(RoleMenuOperationDTO roleMenuOperationDTO);

    public RoleMenuOperationPO getRMO(@Param("id") Integer id);

}
