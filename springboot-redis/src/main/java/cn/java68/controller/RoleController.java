package cn.java68.controller;

import cn.java68.base.constants.BaseEnums;
import cn.java68.base.result.Result;
import cn.java68.base.result.ResultUtil;
import cn.java68.model.Role;
import cn.java68.service.IRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

@Api(value = "/role",tags = "角色管理")
@RequestMapping
@Controller
public class RoleController {

    @Resource
    private IRoleService roleService;

    @ApiOperation(value = "获取角色列表",notes = "获取角色列表")
    @RequestMapping(value = "/findRoleList", method = RequestMethod.GET)
    @ResponseBody
    public Result findRoleList(){
        return ResultUtil.successWithData(roleService.findRoleList(), BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }

    @ApiOperation(value = "添加角色",notes = "添加角色")
    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
    @ResponseBody
    public Result addRole(@Valid Role role, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResultUtil.successWithData(bindingResult.getFieldError().getDefaultMessage(), BaseEnums.SUCCESS.code(),BaseEnums.SUCCESS.desc());
        }
        return ResultUtil.successWithData(roleService.addRole(role), BaseEnums.SUCCESS.code(),BaseEnums.SUCCESS.desc());
    }

    @ApiOperation(value = "修改角色",notes = "根据ID修改角色")
    @RequestMapping(value = "/updateRole", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateRole(Role role){
        return ResultUtil.successWithData(roleService.updateRole(role), BaseEnums.SUCCESS.code(),BaseEnums.SUCCESS.desc());
    }

    @ApiOperation(value = "根据ID获取角色",notes = "根据ID获取角色")
    @RequestMapping(value = "/getRoleById", method = RequestMethod.GET)
    @ResponseBody
    public Result getRoleById(Integer id){
        return ResultUtil.successWithData(roleService.getRoleById(id),BaseEnums.SUCCESS.code(),BaseEnums.SUCCESS.desc());
    }

    @ApiOperation(value = "删除角色",notes = "删除角色")
    @RequestMapping(value = "/delRole", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delRole(String id){
        roleService.delRole(id);
        return ResultUtil.successWithStatus(BaseEnums.SUCCESS.desc());
    }
}
