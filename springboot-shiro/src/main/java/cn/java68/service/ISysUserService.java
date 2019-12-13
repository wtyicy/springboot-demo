package cn.java68.service;

import cn.java68.model.SysUser;
import org.apache.catalina.User;

/**
 * 用户 业务层
 *
 */
public interface ISysUserService {
    /**
     * 查找用户
     * @param user
     * @return
     */
    SysUser findUser(SysUser user);
}
