package com.boss.train.rbac.entities.po;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RoleMenuOperationPO {

    private Integer id;

    private Integer rmid;

    private String name;

}
