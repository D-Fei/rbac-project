package com.boss.train.rbac.controller;

import cn.hutool.core.bean.BeanUtil;
import com.boss.train.rbac.entities.dto.RoleMenuOperationDTO;
import com.boss.train.rbac.entities.vo.CommonResult;
import com.boss.train.rbac.entities.vo.RoleMenuOperationVO;
import com.boss.train.rbac.service.RoleMenuOperationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class RoleMenuOperationController {

    @Resource
    private RoleMenuOperationService roleMenuOperationService;

    @Resource
    private RoleMenuOperationDTO roleMenuOperationDTO;

    @PostMapping(value = "/rmo/create")
    public CommonResult createRMO(@RequestBody RoleMenuOperationVO roleMenuOperationVO) {
        int result = roleMenuOperationService.createRMO(roleMenuOperationVO);
        log.debug("***********增加功能结果： " + result);
        if (result > 0) {
            return new CommonResult(200, "增加功能成功！", result);
        }
        return new CommonResult(444, "增加功能失败！", null);
    }

    @GetMapping(value = "/rmo/delete/{id}")
    public CommonResult deleteRMO(@PathVariable("id") Integer id) {
        int result = roleMenuOperationService.deleteRMO(id);
        log.debug("***********删除功能结果： " + result);
        if (result > 0) {
            return new CommonResult(200, "删除功能成功！", result);
        }
        return new CommonResult(444, "删除功能失败！", null);
    }

    @PostMapping(value = "/rmo/update")
    public CommonResult updateRMO(@RequestBody RoleMenuOperationVO roleMenuOperationVO) {
        int result = roleMenuOperationService.updateRMO(roleMenuOperationVO);
        log.debug("***********修改功能结果： " + result);
        if (result > 0) {
            return new CommonResult(200, "修改功能成功！", result);
        }
        return new CommonResult(444, "修改功能失败！", null);
    }

    @GetMapping(value = "/rmo/get/{id}")
    public CommonResult getRMO(@PathVariable("id") Integer id) {
        roleMenuOperationDTO = roleMenuOperationService.getRMO(id);
        log.debug("***********查询功能结果： " + roleMenuOperationDTO);
        if (roleMenuOperationDTO != null) {
            RoleMenuOperationVO roleMenuOperationVO = new RoleMenuOperationVO();
            BeanUtil.copyProperties(roleMenuOperationDTO, roleMenuOperationVO);
            return new CommonResult(200, "查询功能成功！", roleMenuOperationVO);
        }
        return new CommonResult(444, "查询功能失败！", null);
    }

}
