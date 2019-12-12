package cn.java68.mapper.impl;

import cn.java68.mapper.UserDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> findUserList() {
        String sql = "select * from t_user";
        return jdbcTemplate.queryForList(sql);
    }
}
