package cn.java68.service.impl;


import cn.java68.mapper.SysDeptMapper;
import cn.java68.model.SysDept;
import cn.java68.model.SysRole;
import cn.java68.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 部门管理 服务实现
 * 
 * @author ruoyi
 */
@Service
public class SysDeptServiceImpl implements ISysDeptService {

    @Autowired
    private SysDeptMapper sysDeptMapper;
}
