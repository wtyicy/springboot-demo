package cn.java68.model;

import lombok.Data;

/**
 * 用户角色关系表
 */
@Data
public class SysUserRole {
    private String userId; // 用户ID
    private String roleId; // 角色ID
}
