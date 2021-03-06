package com.boss.train.rbac.service;

import com.boss.train.rbac.entities.dto.MenuDTO;
import com.boss.train.rbac.entities.vo.MenuVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuService {

    public Integer createMenu(MenuVO menuVO);

    public Integer deleteMenu(@Param("id") Integer id);

    public Integer updateMenu(MenuVO menuVO);

    public MenuDTO getMenu(@Param("id") Integer id);

    public List<MenuDTO> getMenus();

    public List<MenuDTO> getMenusByParentId(Integer parentId);

}
