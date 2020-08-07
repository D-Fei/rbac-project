package com.boss.train.rbac.entities.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserVO {

    private Integer id;

    private String userName;

    private String password;

}
