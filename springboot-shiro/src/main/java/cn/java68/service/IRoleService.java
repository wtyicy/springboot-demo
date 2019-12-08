package cn.java68.service;

import cn.java68.model.Dept;
import cn.java68.model.Role;

import java.util.List;

public interface IRoleService {

    List<Role> findRoleList(Role role);

    Integer addRole(Role role);

    Integer updateRole(Role role);

    Role getRoleById(String id);

    void delRole(String id);
}
