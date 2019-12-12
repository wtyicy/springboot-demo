package cn.java68.mapper;


import cn.java68.model.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    List<Map<String, Object>> findUserList();

    Integer addUser(User user);

    Integer updateUser(User user);

    User getUserById(String id);

    Integer delUser(String id);
}
