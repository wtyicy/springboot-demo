package cn.java68.service.impl;

import cn.java68.dao.IUserDao;
import cn.java68.model.Permission;
import cn.java68.model.Role;
import cn.java68.model.User;
import cn.java68.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public List<User> findUserList(User user) {
        return userDao.findUserList(user);
    }

    @Override
    public Integer addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public Integer updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public User getUserById(String id) {
        return userDao.getUserById(id);
    }

    @Override
    public Integer delUser(String id) {
        return userDao.delUser(id);
    }

    @Override
    public User getUserByName(String getMapByName) {
        //模拟数据库查询，正常情况此处是从数据库或者缓存查询。
        return getMapByName(getMapByName);
    }

    /**
     * 模拟数据库查询
     * @param userName
     * @return
     */
    private User getMapByName(String userName){
        //共添加两个用户，两个用户都是admin一个角色，
        //wsl有query和add权限，zhangsan只有一个query权限
        Permission permission1 = new Permission("1","query");
        Permission permission2 = new Permission("2","add");
        Set<Permission> permissionSet = new HashSet<>();
        permissionSet.add(permission1);
        permissionSet.add(permission2);
        Role role = new Role("1","admin",permissionSet);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        User user = new User("1","wsl","123456",roleSet);
        Map<String ,User> map = new HashMap<>();
        map.put(user.getUserName(), user);

        Permission permission3 = new Permission("3","query");
        Set<Permission> permissionSet1 = new HashSet<>();
        permissionSet1.add(permission3);
        Role role1 = new Role("2","user",permissionSet1);
        Set<Role> roleSet1 = new HashSet<>();
        roleSet1.add(role1);
        User user1 = new User("2","zhangsan","123456",roleSet1);
        map.put(user1.getUserName(), user1);
        return map.get(userName);
    }
}
