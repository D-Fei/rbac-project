package com.boss.train.rbac.dao;

import com.boss.train.rbac.entities.dto.UserDTO;
import com.boss.train.rbac.entities.po.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {

    public Integer createUser(UserDTO userDTO);

    public Integer deleteUser(@Param("id") Integer id);

    public Integer updateUser(UserDTO userDTO);

    public UserPO getUser(@Param("id") Integer id);

    public List<UserPO> getUsers();

    public UserPO getUserByName(String userName);

}
