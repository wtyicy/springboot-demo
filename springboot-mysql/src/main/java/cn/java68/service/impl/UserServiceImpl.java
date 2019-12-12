package cn.java68.service.impl;

import cn.java68.mapper.UserDao;
import cn.java68.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<Map<String, Object>> findUserList() {
        return userDao.findUserList();
    }
}
