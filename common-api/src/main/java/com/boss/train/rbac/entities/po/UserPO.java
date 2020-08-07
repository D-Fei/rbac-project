package com.boss.train.rbac.entities.po;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserPO {

    private Integer id;

    private String userName;

    private String password;

}
