package cn.java68.controller;

import cn.java68.base.constants.BaseEnums;
import cn.java68.base.result.Result;
import cn.java68.base.result.ResultUtil;
import cn.java68.model.SysUser;
import cn.java68.service.ISysUserService;
import cn.java68.util.ObjectUtil;
import cn.java68.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 登录
 *
 */
@CrossOrigin
@Api(value = "/",tags = "登录接口")
@Controller
@RequestMapping(value = "/sys/")
public class SysLoginController {

    @Resource
    private ISysUserService userService;

    @RequestMapping(value = "/",method = {RequestMethod.GET,RequestMethod.POST})
    public String loginView(){
        return "login";
    }

    @ApiOperation(value = "登录接口",notes = "登录接口")
    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestBody SysUser user){
        //验证数据
        if (ObjectUtil.isNull(user) || StringUtil.isEmpty(user.getUserName()) || StringUtil.isEmpty(user.getPassword())){
            return ResultUtil.failure(BaseEnums.NOT_USER.code(),BaseEnums.NOT_USER.desc());
        }
        //验证用户
        SysUser currentUser =  userService.findUser(user);
        if (ObjectUtil.isNull(currentUser)) {
            return ResultUtil.failure(BaseEnums.LOGIN_FAIL.code(),BaseEnums.LOGIN_FAIL.desc());
        }
        //权限
        return ResultUtil.successWithData(currentUser,BaseEnums.LOGIN_SUCCESS.code(),BaseEnums.LOGIN_SUCCESS.desc());
    }
}
