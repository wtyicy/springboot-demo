package cn.java68.service;

import cn.java68.model.Role;

import java.util.List;

public interface IRoleService {

    List<Role> findRoleList();

    Role addRole(Role role);

    Role updateRole(Role role);

    Role getRoleById(Integer id);

    void delRole(String id);
}
