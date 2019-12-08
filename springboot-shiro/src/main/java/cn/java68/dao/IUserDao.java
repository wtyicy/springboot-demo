package cn.java68.dao;


import cn.java68.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface IUserDao {

    List<User> findUserList(User user);

    Integer addUser(User user);

    Integer updateUser(User user);

    User getUserById(String id);

    Integer delUser(String id);
}
