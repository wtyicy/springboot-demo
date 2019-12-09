package cn.java68.model;

import lombok.Data;

@Data
public class Permission {

    private String id; // 权限Id
    private String name; //权限名称

    public Permission() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Permission(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
