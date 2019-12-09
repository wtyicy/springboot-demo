package cn.java68.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
public class Role {

    @NotNull(message = "ID不能为空")
    private String id;

    @NotNull(message = "角色名称不能为空")
    private String roleName;

    /**
     * 角色对应权限集合
     */
    private Set<Permission> permission;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Permission> getPermission() {
        return permission;
    }

    public void setPermission(Set<Permission> permission) {
        this.permission = permission;
    }

    public Role() {
    }

    public Role(@NotNull(message = "ID不能为空") String id, @NotNull(message = "角色名称不能为空") String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Role(@NotNull(message = "ID不能为空") String id, @NotNull(message = "角色名称不能为空") String roleName, Set<Permission> permission) {
        this.id = id;
        this.roleName = roleName;
        this.permission = permission;
    }
}
