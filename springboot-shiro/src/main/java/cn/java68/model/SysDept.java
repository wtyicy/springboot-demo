package cn.java68.model;

import lombok.Data;

/**
 * 部门表
 */
@Data
public class SysDept {

    private String deptId;  // 部门ID
    private String deptName; // 部门名字
    private String parentId; // 父部门ID
}
