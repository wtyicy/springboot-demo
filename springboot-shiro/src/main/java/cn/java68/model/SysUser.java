package cn.java68.model;

import lombok.Data;

/**
 * 用户表
 */
@Data
public class SysUser {

    private String userId; // 用户ID
    private String userName; // 用户名
    private String password;  // 密码
    private String salt; // 盐加密
    private String deptId; // 部门ID
}
