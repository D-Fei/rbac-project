package com.boss.train.rbac.entities.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RoleDTO {

    private Integer id;

    private String role;

}
