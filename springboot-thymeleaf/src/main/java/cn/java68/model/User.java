package cn.java68.model;

import lombok.Data;

@Data
public class User {

    private String id; // 用户ID
    private String userName; // 用户姓名
    private String age; // 年龄
    private String birthday; //生日
    private String password; // 用户密码

}
