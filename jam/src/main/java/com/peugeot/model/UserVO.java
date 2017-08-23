package com.peugeot.model;

import lombok.Data;

/**
 * 用户信息
 * Created by 柏世民 on 2017/8/11.
 */
@Data
public class UserVO {

    private Integer id;

    private String userName;

    private String passWord;

    private String roles;

    private String nickName;

}
