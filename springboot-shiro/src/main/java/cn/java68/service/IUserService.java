package cn.java68.service;


import cn.java68.model.User;

import java.util.List;
import java.util.Map;

public interface IUserService {

    /**
     * 获取用户信息
     * @return
     */
    List<User> findUserList(User user);

    Integer addUser(User user);

    Integer updateUser(User user);

    User getUserById(String id);

    Integer delUser(String id);

    User getUserByName(String userName);
}
