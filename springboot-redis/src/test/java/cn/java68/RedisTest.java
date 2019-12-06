package cn.java68;

import cn.java68.model.Role;
import cn.java68.model.User;
import cn.java68.service.IRoleService;
import cn.java68.service.UserService;
import cn.java68.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)//设置启动器
@SpringBootTest(classes={SpringbootRedisApplication.class})//指定启动类
public class RedisTest {

    @Resource
    private RedisUtil redisUtil;


    @Resource
    private IRoleService roleService;

    @Test
    public void setRedisTest(){
        redisUtil.set("roleList",roleService.findRoleList());
    }

    @Test
    public void getRedisTest(){
        List<Role> roleList = (List<Role>) redisUtil.get("roleList");
        for (Role role : roleList) {
            System.out.println(role);
        }
    }
}
