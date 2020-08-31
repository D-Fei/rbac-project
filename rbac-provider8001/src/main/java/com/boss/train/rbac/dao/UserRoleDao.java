package com.boss.train.rbac.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRoleDao {

    public List<Integer> getRoleIdByUserId(Integer uid);

}
