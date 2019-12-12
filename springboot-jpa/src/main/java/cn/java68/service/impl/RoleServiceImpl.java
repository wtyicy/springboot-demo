package cn.java68.service.impl;

import cn.java68.mapper.IRoleDao;
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
    public List<Role> findRoleList() {
        return roleDao.findAll();
    }

    @Override
    public Role addRole(Role role) {
        return roleDao.save(role);
    }

    @Override
    public Role updateRole(Role role) {
        return roleDao.save(role);
    }

    @Override
    public Role getRoleById(Integer id) {
        return roleDao.findById(Integer.valueOf(id)).get();
    }

    @Override
    public void delRole(String id) {
        roleDao.deleteById(Integer.valueOf(id));
    }
}
