package cn.java68.controller;


import cn.java68.model.SysMenu;
import cn.java68.service.ISysMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/sys/menu")
public class SysMenuController {

    @Resource
    private ISysMenuService menuService;

    /**
     * 根据用户Id获取菜单树数据
     * @param userId
     * @return
     */
    @RequestMapping(value = {"/",""})
    @ResponseBody
    public List<SysMenu> selectMenuTreeByUserId(String userId) {
        return menuService.selectMenuTreeByUserId(userId);
    }

}