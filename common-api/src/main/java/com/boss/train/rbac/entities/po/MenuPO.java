package com.boss.train.rbac.entities.po;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class MenuPO {

    private Integer id;

    private String name;

    private String path;

    private boolean hidden;

    private Integer parentId;

    private List<MenuPO> children;

}
