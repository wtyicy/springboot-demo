package cn.java68.service.impl;


import cn.java68.mapper.SysMenuMapper;
import cn.java68.model.SysMenu;
import cn.java68.service.ISysMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 菜单 业务层处理
 * 
 * @author ruoyi
 */
@Service
public class SysMenuServiceImpl implements ISysMenuService {

    @Resource
    private SysMenuMapper menuMapper;

    @Override
    public List<SysMenu> selectMenuTreeByUserId(String userId) {
        return menuMapper.selectMenuTreeByUserId(userId);
    }
}
