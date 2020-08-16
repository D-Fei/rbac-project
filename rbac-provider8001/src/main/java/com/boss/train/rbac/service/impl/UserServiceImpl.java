package com.boss.train.rbac.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.boss.train.rbac.dao.UserDao;
import com.boss.train.rbac.entities.dto.UserDTO;
import com.boss.train.rbac.entities.po.UserPO;
import com.boss.train.rbac.entities.vo.UserVO;
import com.boss.train.rbac.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private UserDTO userDTO;

    @Override
    public Integer createUser(UserVO userVO) {
        BeanUtil.copyProperties(userVO,userDTO);
        return userDao.createUser(userDTO);
    }

    @Override
    public Integer deleteUser(Integer id) {
        return userDao.deleteUser(id);
    }

    @Override
    public Integer updateUser(UserVO userVO) {
        BeanUtil.copyProperties(userVO,userDTO);
        return userDao.updateUser(userDTO);
    }

    @Override
    public UserDTO getUser(Integer id) {
        BeanUtil.copyProperties(userDao.getUser(id),userDTO);
        return userDTO;
    }

    @Override
    public List<UserDTO> getUsers() {
        List<UserPO> userPOS = userDao.getUsers();
        List<UserDTO> userDTOS = new LinkedList<>();
        for (UserPO userPO : userPOS) {
            BeanUtil.copyProperties(userPO,userDTO);
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }
}
