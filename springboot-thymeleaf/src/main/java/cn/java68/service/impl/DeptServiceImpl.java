package cn.java68.service.impl;

import cn.java68.dao.IDeptDao;
import cn.java68.model.Dept;
import cn.java68.service.IDeptService;
import cn.java68.util.RedisUtil;
import jdk.internal.org.objectweb.asm.util.TraceClassVisitor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptServiceImpl implements IDeptService {

    @Resource
    private IDeptDao deptDao;

    @Resource
    private RedisUtil redisUtil;


    @Override
    public List<Dept> findDeptList(Dept dept) {
        List<Dept> deptList = (List<Dept>) redisUtil.get("deptList");
        if (deptList == null){
        deptList = deptDao.findDeptList(dept);

            redisUtil.set("deptList",deptList,60);
        }

        return deptList;
    }

    @Override
    @Transactional
    public Integer addDept(Dept dept) {
        if (redisUtil.hasKey("deptList")){
            redisUtil.del("deptList");
        }
        return deptDao.addDept(dept);
    }

    @Override
    public Integer updateDept(Dept dept) {
        if (redisUtil.hasKey("deptList")){
            redisUtil.del("deptList");
        }
        return deptDao.updateDept(dept);
    }

    @Override
    public Dept getDeptById(String id) {
        return deptDao.getDeptById(id);
    }

    @Override
    public Integer delDept(String id) {
        if (redisUtil.hasKey("deptList")){
            redisUtil.del("deptList");
        }
        return deptDao.delDept(id);
    }
}
