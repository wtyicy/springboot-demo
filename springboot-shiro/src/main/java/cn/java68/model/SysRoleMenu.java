package cn.java68.model;

import lombok.Data;

/**
 * 角色菜单关系表
 */
@Data
public class SysRoleMenu {
    private String roleId; // 角色ID
    private String menuId; // 菜单ID
}
