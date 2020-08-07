package com.boss.train.rbac.service;

import com.boss.train.rbac.entities.vo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "rbac-provider")
public interface RBACService {

    @GetMapping(value = "/user/get/{id}")
    public CommonResult getUser(@PathVariable("id") Integer id);

}
