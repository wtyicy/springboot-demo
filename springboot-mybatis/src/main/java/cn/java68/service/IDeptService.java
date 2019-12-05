package cn.java68.service;


import cn.java68.model.Dept;

import java.util.List;


public interface IDeptService {

    List<Dept> findDeptList();

    Integer addDept(Dept dept);

    Integer updateDept(Dept dept);

    Dept getDeptById(String id);

    Integer delDept(String id);
}
