package com.boss.train.rbac.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.boss.train.rbac.dao.MenuDao;
import com.boss.train.rbac.entities.dto.MenuDTO;
import com.boss.train.rbac.entities.po.MenuPO;
import com.boss.train.rbac.entities.vo.MenuVO;
import com.boss.train.rbac.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuDao menuDao;

    @Resource
    private MenuDTO menuDTO;

    @Override
    public Integer createMenu(MenuVO menuVO) {
        BeanUtil.copyProperties(menuVO,menuDao);
        return menuDao.createMenu(menuDTO);
    }

    @Override
    public Integer deleteMenu(Integer id) {
        return menuDao.deleteMenu(id);
    }

    @Override
    public Integer updateMenu(MenuVO menuVO) {
        BeanUtil.copyProperties(menuVO,menuDTO);
        return menuDao.updateMenu(menuDTO);
    }

    @Override
    public MenuDTO getMenu(Integer id) {
        BeanUtil.copyProperties(menuDao.getMenu(id),menuDTO);
        return menuDTO;
    }

    @Override
    public List<MenuDTO> getMenus() {
        List<MenuDTO> menuDTOS = getMenusByParentId(0);
        for (MenuDTO menuDTO : menuDTOS) {
            if (menuDTO.getParentId() == 0) {
                menuDTO.setChildren(getMenusByParentId(menuDTO.getId()));
            }
        }
        return menuDTOS;
    }

    @Override
    public List<MenuDTO> getMenusByParentId(Integer parentId) {
        List<MenuPO> menuPOS = menuDao.getMenusByParentId(parentId);
        List<MenuDTO> menuDTOS = new LinkedList<>();
        for (MenuPO menuPO : menuPOS) {
            MenuDTO menuDTO = new MenuDTO();
            BeanUtil.copyProperties(menuPO, menuDTO);
            menuDTOS.add(menuDTO);
        }
        return menuDTOS;
    }
}
