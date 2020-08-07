package com.boss.train.rbac.dao;

import com.boss.train.rbac.entities.dto.MenuDTO;
import com.boss.train.rbac.entities.po.MenuPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MenuDao {

    public Integer createMenu(MenuDTO menuDTO);

    public Integer deleteMenu(@Param("id") Integer id);

    public Integer updateMenu(MenuDTO menuDTO);

    public MenuPO getMenu(@Param("id") Integer id);

}
