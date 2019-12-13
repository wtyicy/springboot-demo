package cn.java68.service.impl;


import cn.java68.mapper.SysUserMapper;
import cn.java68.model.SysUser;
import cn.java68.service.ISysUserService;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户 业务层处理
 * 
 * @author ruoyi
 */
@Service
public class SysUserServiceImpl implements ISysUserService {

    @Resource
    private SysUserMapper userMapper;

    @Override
    public SysUser findUser(SysUser user) {
        return userMapper.findUser(user);
    }
}
