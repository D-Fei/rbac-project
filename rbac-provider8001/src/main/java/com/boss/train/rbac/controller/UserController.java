package com.boss.train.rbac.controller;

import cn.hutool.core.bean.BeanUtil;
import com.boss.train.rbac.entities.dto.UserDTO;
import com.boss.train.rbac.entities.vo.CommonResult;
import com.boss.train.rbac.entities.vo.UserVO;
import com.boss.train.rbac.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class UserController {

    @Resource
    private UserDTO userDTO;

    @Resource
    private UserService userService;


    @PostMapping(value = "/user/create")
    public CommonResult createUser(@RequestBody UserVO userVO) {
        int result = userService.createUser(userVO);
        log.debug("**********增加用户结果： " + result);
        if (result > 0) {
            return new CommonResult(200, "增加用户成功！", result);
        }
        return new CommonResult(444, "增加用户失败！", null);
    }

    @GetMapping(value = "/user/delete/{id}")
    public CommonResult deleteUser(@PathVariable("id") Integer id) {
        int result = userService.deleteUser(id);
        log.debug("**********删除结果： " + result);
        if (result > 0) {
            return new CommonResult(200, "删除用户成功！", result);
        }
        return new CommonResult(444, "删除用户失败！", null);
    }

    @PostMapping(value = "/user/update")
    public CommonResult updateUser(@RequestBody UserVO userVO) {
        int result = userService.updateUser(userVO);
        log.debug("*************修改结果： " + result);
        if (result > 0) {
            return new CommonResult(200, "修改用户成功！", result);
        }
        return new CommonResult(444, "修改用户失败！", null);
    }

    @CrossOrigin
    @GetMapping(value = "/user/get/{id}")
    public CommonResult getUser(@PathVariable("id") Integer id) {
        userDTO = userService.getUser(id);
        log.debug("************查询结果： " + userDTO);
        if (userDTO != null) {
            UserVO userVO = new UserVO();
            BeanUtil.copyProperties(userDTO, userVO);
            return new CommonResult(200, "查询成功！", userVO);
        }
        return new CommonResult(444, "查询失败！", null);
    }

}
