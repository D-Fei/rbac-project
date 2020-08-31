package com.boss.train.rbac.controller;

import cn.hutool.core.bean.BeanUtil;
import com.boss.train.rbac.entities.dto.RoleDTO;
import com.boss.train.rbac.entities.vo.CommonResult;
import com.boss.train.rbac.entities.vo.RoleVO;
import com.boss.train.rbac.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@RestController
@Slf4j
public class RoleController {

    @Resource
    private RoleService roleService;

    @Resource
    private RoleDTO roleDTO;

    @CrossOrigin
    @PostMapping(value = "/role/create")
    public CommonResult createRole(@RequestBody RoleVO roleVO) {
        int result = roleService.createRole(roleVO);
        log.debug("***********增加角色结果： " + result);
        if (result > 0) {
            roleDTO = roleService.getRoleByName(roleVO.getRole());
            return new CommonResult(200, "增加角色成功！", roleDTO);
        }
        return new CommonResult(444, "增加角色失败！", null);
    }

    @CrossOrigin
    @GetMapping(value = "/role/delete/{id}")
    public CommonResult deleteRole(@PathVariable("id") Integer id) {
        int result = roleService.deleteRole(id);
        log.debug("***********删除角色结果： " + result);
        if (result > 0) {
            return new CommonResult(200, "删除角色成功！", result);
        }
        return new CommonResult(444, "删除角色失败！", null);
    }

    @CrossOrigin
    @PostMapping(value = "/role/update")
    public CommonResult updateRole(@RequestBody RoleVO roleVO) {
        int result = roleService.updateRole(roleVO);
        log.debug("*********修改结果： " + result);
        if (result > 0) {
            roleDTO = roleService.getRole(roleVO.getId());
            return new CommonResult(200, "修改角色成功！", roleDTO);
        }
        return new CommonResult(444, "修改角色失败！", null);
    }

    @GetMapping("/role/get/{id}")
    public CommonResult getRole(@PathVariable("id") Integer id) {
        roleDTO = roleService.getRole(id);
        log.debug("*************查询结果： " + roleDTO);
        if (roleDTO != null) {
            RoleVO roleVO = new RoleVO();
            BeanUtil.copyProperties(roleDTO, roleVO);
            return new CommonResult(200, "查询成功！", roleVO);
        }
        return new CommonResult(444, "查询失败！", null);
    }

    @CrossOrigin
    @GetMapping(value = "/roles/get")
    public CommonResult getRoles() {
        List<RoleDTO> roleDTOS = roleService.getRoles();
        log.debug("*************查询结果：" + roleDTOS);
        if (roleDTOS != null) {
            List<RoleVO> roleVOS = new LinkedList<>();
            for (RoleDTO roleDTO : roleDTOS) {
                RoleVO roleVO = new RoleVO();
                BeanUtil.copyProperties(roleDTO, roleVO);
                roleVOS.add(roleVO);
            }
            return new CommonResult(200, "查询成功！", roleVOS);
        }
        return new CommonResult(444, "查询失败！", null);
    }

}
