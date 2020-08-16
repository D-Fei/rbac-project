package com.boss.train.rbac.service;

import com.boss.train.rbac.entities.dto.UserDTO;
import com.boss.train.rbac.entities.vo.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    public Integer createUser(UserVO userVO);

    public Integer deleteUser(@Param("id") Integer id);

    public Integer updateUser(UserVO userVO);

    public UserDTO getUser(@Param("id") Integer id);

    public List<UserDTO> getUsers();

}
