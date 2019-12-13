package cn.java68.model;

import lombok.Data;

/**
 * 角色部门关系表
 */
@Data
public class SysRoleDept {
    private String roleId; // 角色ID
    private String deptId; // 部门ID
}
