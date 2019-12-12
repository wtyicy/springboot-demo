package cn.java68.service.impl;

import cn.java68.mapper.IDeptDao;
import cn.java68.model.Dept;
import cn.java68.service.IDeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptServiceImpl implements IDeptService {

    @Resource
    private IDeptDao deptDao;


    @Override
    public List<Dept> findDeptList() {
        return deptDao.findDeptList();
    }

    @Override
    public Integer addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Integer updateDept(Dept dept) {
        return deptDao.updateDept(dept);
    }

    @Override
    public Dept getDeptById(String id) {
        return deptDao.getDeptById(id);
    }

    @Override
    public Integer delDept(String id) {
        return deptDao.delDept(id);
    }
}
