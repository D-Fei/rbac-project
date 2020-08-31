package com.boss.train.rbac.entities.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class MenuVO {

    private Integer id;

    private String name;

    private String path;

    private boolean hidden;

    private Integer parentId;

    private List<MenuVO> children;

}
