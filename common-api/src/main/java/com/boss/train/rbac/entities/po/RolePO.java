package com.boss.train.rbac.entities.po;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RolePO {

    private Integer id;

    private String role;

}
