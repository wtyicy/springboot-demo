package cn.java68.service;


import cn.java68.model.SysMenu;

import java.util.List;

/**
 * 菜单 业务层
 *
 */
public interface ISysMenuService {

    /**
     * 根据用户Id获取菜单树数据
     * @param userId
     * @return
     */
    List<SysMenu> selectMenuTreeByUserId(String userId);
}
