package cn.java68.service;


import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * 获取用户信息
     * @return
     */
    List<Map<String, Object>> findUserList();
}
