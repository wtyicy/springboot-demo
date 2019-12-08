package cn.java68.model;

import lombok.Data;

import java.util.Set;

@Data
public class User {

    private String id; // 用户ID
    private String userName; // 用户姓名
    private String password; // 用户密码
    /**
     * 用户对应的角色集合
     */
    private Set<Role> roles;

    public User(String id, String userName, String password, Set<Role> roles) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }
}
