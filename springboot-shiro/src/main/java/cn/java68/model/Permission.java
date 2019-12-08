package cn.java68.model;

import lombok.Data;

@Data
public class Permission {

    private String id; // 权限Id
    private String name; //权限名称

    public Permission(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
