package cn.java68.service.impl;

import cn.java68.dao.IDeptDao;
import cn.java68.model.Dept;
import cn.java68.service.IDeptService;
import jdk.internal.org.objectweb.asm.util.TraceClassVisitor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptServiceImpl implements IDeptService {

    @Resource
    private IDeptDao deptDao;


    @Override
    public List<Dept> findDeptList(Dept dept) {
        return deptDao.findDeptList(dept);
    }

    @Override
    @Transactional
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
