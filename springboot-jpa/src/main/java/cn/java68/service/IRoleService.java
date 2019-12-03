package cn.java68.service;

import cn.java68.model.Role;
import cn.java68.model.User;

import java.util.List;
import java.util.Map;

public interface IRoleService {

    List<Role> findRoleList();

    Role addRole(Role role);

    Role updateRole(Role role);

    Role getRoleById(Integer id);

    void delRole(String id);
}
