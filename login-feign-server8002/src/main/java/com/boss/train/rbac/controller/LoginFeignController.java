package com.boss.train.rbac.controller;

import com.boss.train.rbac.entities.vo.CommonResult;
import com.boss.train.rbac.service.RBACService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class LoginFeignController {

    @Resource
    private RBACService rbacService;

    @GetMapping(value = "/login/user/get/{id}")
    public CommonResult getUser(@PathVariable("id") Integer id) {
        return rbacService.getUser(id);
    }

}
