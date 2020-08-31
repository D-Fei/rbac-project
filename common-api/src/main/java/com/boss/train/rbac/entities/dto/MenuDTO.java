package com.boss.train.rbac.entities.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class MenuDTO {

    private Integer id;

    private String name;

    private String path;

    private boolean hidden;

    private Integer parentId;

    private List<MenuDTO> children;

}
