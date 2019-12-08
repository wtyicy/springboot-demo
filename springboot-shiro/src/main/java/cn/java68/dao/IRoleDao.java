package cn.java68.dao;

import cn.java68.model.Dept;
import cn.java68.model.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IRoleDao {
    List<Role> findRoleList(Role role);

    Integer addRole(Role role);

    Integer updateRole(Role role);

    Role getRoleById(String id);

    Integer delRole(String id);
}
