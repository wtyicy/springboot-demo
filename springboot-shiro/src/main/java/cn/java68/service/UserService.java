package cn.java68.service;


import cn.java68.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * 获取用户信息
     * @return
     */
    List<Map<String, Object>> findUserList();

    Integer addUser(User user);

    Integer updateUser(User user);

    User getUserById(String id);

    Integer delUser(String id);
}
