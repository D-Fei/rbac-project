package com.boss.train.rbac.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.boss.train.rbac.dao.UserDao;
import com.boss.train.rbac.dao.UserRoleDao;
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
    private UserRoleDao userRoleDao;

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
            UserDTO userDTO = new UserDTO();
            BeanUtil.copyProperties(userPO,userDTO);
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    @Override
    public UserDTO getUserByName(String userName) {
        BeanUtil.copyProperties(userDao.getUserByName(userName), userDTO);
        return userDTO;
    }

    @Override
    public boolean login(UserVO userVO) {
        BeanUtil.copyProperties(userDao.getUserByName(userVO.getUserName()),userDTO);
        if (userVO.getPassword().equals(userDTO.getPassword())) {
            userVO.setId(userDTO.getId());
            return true;
        }
        return false;
    }

    @Override
    public List<Integer> getRoleId(Integer uid) {
        List<Integer> rid = userRoleDao.getRoleIdByUserId(uid);
        if (rid != null) {
            return rid;
        }
        return null;
    }
}
