package cn.java68.mapper;


import cn.java68.model.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IDeptDao {

    List<Dept> findDeptList();

    Integer addDept(Dept dept);

    Integer updateDept(Dept dept);

    Dept getDeptById(String id);

    Integer delDept(String id);
}
