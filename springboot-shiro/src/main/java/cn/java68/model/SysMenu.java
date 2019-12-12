package cn.java68.model;

import lombok.Data;

@Data
public class SysMenu {

    private String menuId; // 菜单ID
    private String menuName; // 菜单名称
    private String parentId; // 父菜单ID
    private String url; // 菜单URL
    private String menuType; // 菜单类型 0：目录 1：菜单 2：按钮
    private String perms; // 权限字符串
}
