package cn.java68.controller;

import cn.java68.base.constants.BaseEnums;
import cn.java68.base.result.Result;
import cn.java68.base.result.ResultUtil;
import cn.java68.model.Dept;
import cn.java68.service.IDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Api(value = "/dept",tags = "部门管理")
@RequestMapping
@Controller
public class DeptController {

    @Resource
    private IDeptService deptService;

    @ApiOperation(value = "获取部门列表",notes = "获取部门列表")
    @RequestMapping(value = "/findDeptList", method = RequestMethod.GET)
    @ResponseBody
    public Result findDeptList(){
        return ResultUtil.successWithData(deptService.findDeptList(), BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }

    @ApiOperation(value = "添加部门",notes = "添加部门")
    @RequestMapping(value = "/addDept", method = RequestMethod.POST)
    @ResponseBody
    public Result addDept(Dept dept){
        dept.setId("787886");
        return ResultUtil.successWithData(deptService.addDept(dept), BaseEnums.SUCCESS.code(),BaseEnums.SUCCESS.desc());
    }

    @ApiOperation(value = "修改部门",notes = "根据ID修改部门")
    @RequestMapping(value = "/updateDept", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateDept(Dept dept){
        return ResultUtil.successWithData(deptService.updateDept(dept), BaseEnums.SUCCESS.code(),BaseEnums.SUCCESS.desc());
    }

    @ApiOperation(value = "根据ID获取部门",notes = "根据ID获取部门")
    @RequestMapping(value = "/getDeptById", method = RequestMethod.GET)
    @ResponseBody
    public Result getDeptById(String id){
        return ResultUtil.successWithData(deptService.getDeptById(id),BaseEnums.SUCCESS.code(),BaseEnums.SUCCESS.desc());
    }

    @ApiOperation(value = "删除部门",notes = "删除部门")
    @RequestMapping(value = "/delDept", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delDept(String id){
        deptService.delDept(id);
        return ResultUtil.successWithStatus(BaseEnums.SUCCESS.desc());
    }

    @RequestMapping(value = {"/dept", ""},method = {RequestMethod.GET,RequestMethod.POST})
    public String deptViews(){
        return "dept/deptList";
    }
}
