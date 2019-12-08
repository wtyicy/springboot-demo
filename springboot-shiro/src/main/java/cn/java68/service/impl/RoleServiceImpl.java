package cn.java68.service.impl;

import cn.java68.dao.IRoleDao;
import cn.java68.model.Role;
import cn.java68.service.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Resource
    private IRoleDao roleDao;

    @Override
    public List<Role> findRoleList(Role role) {
        return roleDao.findRoleList(role);
    }

    @Override
    public Integer addRole(Role role) {
        return roleDao.addRole(role);
    }

    @Override
    public Integer updateRole(Role role) {
        return roleDao.updateRole(role);
    }

    @Override
    public Role getRoleById(String id) {
        return roleDao.getRoleById(id);
    }

    @Override
    public void delRole(String id) {
        roleDao.delRole(id);
    }
}
