package cn.java68.mapper;

import cn.java68.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleDao extends JpaRepository<Role,Integer> {
}
