package cn.java68.controller;

import cn.java68.base.constants.BaseEnums;
import cn.java68.base.result.Result;
import cn.java68.base.result.ResultUtil;
import cn.java68.model.Dept;
import cn.java68.service.IDeptService;
import cn.java68.util.IdUtils;
import cn.java68.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Api(value = "/dept",tags = "部门管理")
@RequestMapping
@Controller
public class DeptController {


    @Resource
    private IDeptService deptService;

    @ApiOperation(value = "获取部门列表",notes = "获取部门列表")
    @RequestMapping(value = "/findDeptList", method = RequestMethod.POST)
    @ResponseBody
    public Result findDeptList(@RequestBody Dept dept){
//         if ("undefined".equals(dept.getName())){
//            dept.setName("");
//        }
//        Dept dept = new Dept();
//        dept.setName(name);
        return ResultUtil.successWithData(deptService.findDeptList(dept), BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }

    @ApiOperation(value = "添加部门",notes = "添加部门")
    @RequestMapping(value = "/addDept", method = RequestMethod.POST)
    @ResponseBody
    public Result addDept(Dept dept){
        dept.setId(IdUtils.getRandomIdByUUID());
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
