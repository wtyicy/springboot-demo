package cn.java68.mapper;


import java.util.List;
import java.util.Map;

public interface UserDao {

    List<Map<String, Object>> findUserList();
}
