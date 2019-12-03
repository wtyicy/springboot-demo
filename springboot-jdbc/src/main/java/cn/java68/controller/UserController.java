package cn.java68.controller;

import cn.java68.base.constants.BaseEnums;
import cn.java68.base.result.Result;
import cn.java68.base.result.ResultUtil;
import cn.java68.model.User;
import cn.java68.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Api(value = "/user",tags = "用户管理")
@RequestMapping
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "获取用户列表",notes = "获取用户列表")
    @RequestMapping(value = "/findUserList", method = RequestMethod.GET)
    @ResponseBody
    public Result findUserList(){
        return ResultUtil.successWithData(userService.findUserList(), BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
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
}
