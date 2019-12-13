package cn.java68.model;

import lombok.Data;

/**
 * 用户岗位关系表
 */
@Data
public class SysUserPost {
    private String userId; // 用户ID
    private String postId; // 岗位ID
}
