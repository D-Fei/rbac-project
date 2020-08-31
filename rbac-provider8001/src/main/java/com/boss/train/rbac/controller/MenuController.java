package com.boss.train.rbac.controller;

import cn.hutool.core.bean.BeanUtil;
import com.boss.train.rbac.entities.dto.MenuDTO;
import com.boss.train.rbac.entities.vo.CommonResult;
import com.boss.train.rbac.entities.vo.MenuVO;
import com.boss.train.rbac.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class MenuController {

    @Resource
    private MenuService menuService;

    @Resource
    private MenuDTO menuDTO;

    @PostMapping(value = "/menu/create")
    public CommonResult createMenu(@RequestBody MenuVO menuVO) {
        int result = menuService.createMenu(menuVO);
        log.debug("**********增加菜单结果： " + result);
        if (result > 0) {
            return new CommonResult(200, "增加菜单成功！", result);
        }
        return new CommonResult(444, "增加菜单失败！", null);
    }

    @GetMapping(value = "/menu/delete/{id}")
    public CommonResult deleteMenu(@PathVariable("id") Integer id) {
        int result = menuService.deleteMenu(id);
        log.debug("*************删除菜单结果： " + result);
        if (result > 0) {
            return new CommonResult(200, "删除菜单成功！", result);
        }
        return new CommonResult(444, "删除菜单失败！", null);
    }

    @PostMapping(value = "/menu/update")
    public CommonResult updateMenu(@RequestBody MenuVO menuVO) {
        int result = menuService.updateMenu(menuVO);
        log.debug("***********修改菜单结果： " + result);
        if (result > 0) {
            return new CommonResult(200, "修改菜单成功！", result);
        }
        return new CommonResult(444, "修改菜单失败！", null);
    }

    @GetMapping(value = "/menu/get/{id}")
    public CommonResult getMenu(@PathVariable("id") Integer id) {
        menuDTO = menuService.getMenu(id);
        log.debug("***********查询菜单结果： " + menuDTO);
        if (menuDTO != null) {
            MenuVO menuVO = new MenuVO();
            BeanUtil.copyProperties(menuDTO, menuVO);
            return new CommonResult(200, "查询菜单成功！", menuVO);
        }
        return new CommonResult(444, "查询菜单成功！", null);
    }

    @CrossOrigin
    @GetMapping(value = "/menus/get")
    public CommonResult getMenus() {
        List<MenuDTO> menuDTOS = menuService.getMenus();
        log.debug("***********查询结果：" + menuDTOS);
        if (menuDTOS != null) {
            return new CommonResult(200, "查询菜单成功！", menuDTOS);
        }
        return new CommonResult(200, "查询菜单失败！", null);
    }

}
