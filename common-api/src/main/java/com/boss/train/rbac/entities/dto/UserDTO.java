package com.boss.train.rbac.entities.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserDTO {

    private Integer id;

    private String userName;

    private String password;

}
