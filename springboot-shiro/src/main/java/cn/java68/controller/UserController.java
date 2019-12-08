package cn.java68.controller;

import cn.java68.base.constants.BaseEnums;
import cn.java68.base.result.Result;
import cn.java68.base.result.ResultUtil;
import cn.java68.model.User;
import cn.java68.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Api(value = "/user",tags = "用户管理")
@RequestMapping
@Controller
public class UserController {

    @Resource
    private IUserService userService;

    @ApiOperation(value = "获取用户列表",notes = "获取用户列表")
    @RequestMapping(value = "/findUserList", method = RequestMethod.GET)
    @ResponseBody
    public Result findUserList(User user){
        return ResultUtil.successWithData(userService.findUserList(user), BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }

    @ApiOperation(value = "添加用户",notes = "添加用户")
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public Result addUser(User user){
        return ResultUtil.successWithStatus(userService.addUser(user),BaseEnums.SUCCESS.desc());
    }

    @ApiOperation(value = "修改用户",notes = "根据ID修改用户")
    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateUser(User user){
        return ResultUtil.successWithStatus(userService.updateUser(user),BaseEnums.SUCCESS.desc());
    }

    @ApiOperation(value = "根据ID获取用户",notes = "根据ID获取用户")
    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    @ResponseBody
    public Result getUserById(String id){
        return ResultUtil.successWithData(userService.getUserById(id),BaseEnums.SUCCESS.desc());
    }

    @ApiOperation(value = "删除用户",notes = "删除用户")
    @RequestMapping(value = "/delUser", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delUser(String id){
        return ResultUtil.successWithData(userService.delUser(id),BaseEnums.SUCCESS.desc());
    }

    @ApiOperation(value = "根据name获取用户",notes = "根据ID获取用户")
    @RequestMapping(value = "/getUserByName", method = RequestMethod.GET)
    @ResponseBody
    public Result getUserByName(String name){
        return ResultUtil.successWithData(userService.getUserByName(name),BaseEnums.SUCCESS.desc());
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(User user) {
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                user.getUserName(),
                user.getPassword()
        );
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
//            subject.checkRole("admin");
//            subject.checkPermissions("query", "add");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "账号或密码错误！";
        } catch (AuthorizationException e) {
            e.printStackTrace();
            return "没有权限";
        }
        return "login success";
    }
    //注解验角色和权限
    @RequiresRoles("admin")
    @RequiresPermissions("add")
    @RequestMapping("/index")
    public String index() {
        return "index!";
    }
}
