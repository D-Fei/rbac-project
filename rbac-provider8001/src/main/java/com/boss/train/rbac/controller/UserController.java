package com.boss.train.rbac.controller;

import cn.hutool.core.bean.BeanUtil;
import com.boss.train.rbac.entities.dto.UserDTO;
import com.boss.train.rbac.entities.vo.CommonResult;
import com.boss.train.rbac.entities.vo.UserVO;
import com.boss.train.rbac.service.RoleService;
import com.boss.train.rbac.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@Slf4j
public class UserController {

    @Resource
    private UserDTO userDTO;

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;


    @CrossOrigin
    @PostMapping(value = "/user/create")
    public CommonResult createUser(@RequestBody UserVO userVO) {
        int result = userService.createUser(userVO);
        log.debug("**********增加用户结果： " + result);
        if (result > 0) {
            userDTO = userService.getUserByName(userVO.getUserName());
            return new CommonResult(200, "增加用户成功！", userDTO);
        }
        return new CommonResult(444, "增加用户失败！", null);
    }

    @CrossOrigin
    @GetMapping(value = "/user/delete/{id}")
    public CommonResult deleteUser(@PathVariable("id") Integer id) {
        int result = userService.deleteUser(id);
        log.debug("**********删除结果： " + result);
        if (result > 0) {
            return new CommonResult(200, "删除用户成功！", result);
        }
        return new CommonResult(444, "删除用户失败！", null);
    }

    @CrossOrigin
    @PostMapping(value = "/user/update")
    public CommonResult updateUser(@RequestBody UserVO userVO) {
        int result = userService.updateUser(userVO);
        log.debug("*************修改结果： " + result);
        if (result > 0) {
            userDTO = userService.getUserByName(userVO.getUserName());
            return new CommonResult(200, "修改用户成功！", userDTO);
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

    @CrossOrigin
    @GetMapping(value = "/users/get")
    public CommonResult getUsers() {
        List<UserDTO> userDTOS = userService.getUsers();
        log.debug("************查询结果：" + userDTOS);
        if (userDTOS != null) {
            List<UserVO> userVOS = new LinkedList<>();
            for (UserDTO user:userDTOS){
                UserVO userVO = new UserVO();
                BeanUtil.copyProperties(user, userVO);
                userVOS.add(userVO);
            }
            return new CommonResult(200, "查询成功！", userVOS);
        }
        return new CommonResult(444, "查询失败！", null);
    }

    @CrossOrigin
    @PostMapping(value = "/user/login")
    public CommonResult login(@RequestBody Map<String,Object> loginInfo) {
//        System.out.println(loginInfo);
        UserVO userVO = new UserVO();
        userVO.setUserName((String) loginInfo.get("username"));
        userVO.setPassword((String) loginInfo.get("password"));
        boolean result = userService.login(userVO);
        log.debug("************登录结果：" + result);
        if (result) {
            Map map = new HashMap();
            map.put("user", userVO);
            map.put("token", userVO.getUserName());
            return new CommonResult(200, "登录成功！", map);
        }
        return new CommonResult(444, "登录失败！", null);
    }

    @CrossOrigin
    @GetMapping(value = "/user/info")
    public CommonResult getInfo(@RequestParam("token") String token, HttpServletResponse response) {
//        response.setHeader("Access-Control-Allow-Origin","*");
//        System.out.println(token);
        userDTO = userService.getUserByName(token);
        log.debug("***********获取结果：" + userDTO);
        if (userDTO != null) {
            UserVO userVO = new UserVO();
            BeanUtil.copyProperties(userDTO, userVO);
            List<Integer> rids = userService.getRoleId(userVO.getId());
            List<String> roleNames = new LinkedList<>();
            String roleName = null;
            for (Integer rid : rids) {
                roleName = roleService.getRole(rid).getRole();
                roleNames.add(roleName);
            }
            Map<String, Object> map = new HashMap<>();
            map.put("user", userVO);
            map.put("roles", roleNames);
            return new CommonResult(200, "获取成功！", map);
        }
        return new CommonResult(444, "获取失败！", null);
    }

    @CrossOrigin
    @GetMapping(value = "/user/show")
    public CommonResult show() {
        List<UserDTO> userDTOS = userService.getUsers();
        if (userDTOS != null) {
            List<Map<String, Object>> list = new ArrayList<>();
            for (UserDTO userDTO : userDTOS) {
                Map<String, Object> map = new HashMap<>();
                List<Integer> rids = userService.getRoleId(userDTO.getId());
                List<String> roleNames = new LinkedList<>();
                String roleName = null;
                for (Integer rid : rids) {
                    roleName = roleService.getRole(rid).getRole();
                    roleNames.add(roleName);
                }
                map.put("id", userDTO.getId());
                map.put("userName", userDTO.getUserName());
                map.put("roles", roleNames);
                list.add(map);
            }
            return new CommonResult(200, "获取成功！", list);
        }
        return new CommonResult(444, "获取失败！", null);
    }

}
