package com.boss.train.rbac.entities.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RoleMenuOperationDTO {

    private Integer id;

    private Integer rmid;

    private String name;

}
