package cn.java68.controller;

import cn.java68.base.constants.BaseEnums;
import cn.java68.base.result.Result;
import cn.java68.base.result.ResultUtil;
import cn.java68.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RequestMapping
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/findUserList", method = RequestMethod.GET)
    @ResponseBody
    public Result findUserList(){
        return ResultUtil.successWithData(userService.findUserList(), BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }
}
