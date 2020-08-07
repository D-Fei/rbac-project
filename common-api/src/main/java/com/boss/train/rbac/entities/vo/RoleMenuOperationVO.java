package com.boss.train.rbac.entities.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RoleMenuOperationVO {

    private Integer id;

    private Integer rmid;

    private String name;

}
