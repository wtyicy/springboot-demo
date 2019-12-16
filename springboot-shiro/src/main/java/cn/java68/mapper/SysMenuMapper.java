package cn.java68.mapper;


import cn.java68.model.SysMenu;

import java.util.List;

public interface SysMenuMapper {

    /**
     * 根据Id获取菜单树
     * @param userId
     * @return
     */
    List<SysMenu> selectMenuTreeByUserId(String userId);
}
