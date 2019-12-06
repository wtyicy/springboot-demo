package cn.java68.dao.impl;

import cn.java68.dao.UserDao;
import cn.java68.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    @Override
    public Integer addUser(User user) {
        String sql = "insert into t_user(id,user_name,age,birthday,password) value(?,?,?,?,?)";
        int result = jdbcTemplate.update(sql,new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, user.getId());
                preparedStatement.setString(2, user.getUserName());
                preparedStatement.setString(3, user.getAge());
                preparedStatement.setString(4, user.getBirthday());
                preparedStatement.setString(5, user.getPassword());
            }
        });
        return result;
    }

    @Override
    public Integer updateUser(User user) {
        String sql = "update t_user set user_name=?, age=?, birthday=?, password=? where id = ?";
        int result = jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(5, user.getId());
                preparedStatement.setString(1, user.getUserName());
                preparedStatement.setString(2, user.getAge());
                preparedStatement.setString(3, user.getBirthday());
                preparedStatement.setString(4, user.getPassword());
            }
        });
        return result;
    }

    @Override
    public User getUserById(String id) {
        String sql = "select * from t_user where id = ?";
        List<User> userList = jdbcTemplate.query(sql, new Object[]{"id"}, new UserRowMapper());
        User user = null;
        if (!userList.isEmpty()){
            user = userList.get(0);
        }
        return user;
    }

    @Override
    public Integer delUser(String id) {
        String sql = "delete from t_user where id = ?";
        return jdbcTemplate.update(sql,id);
    }

    class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getString("id"));
            user.setUserName(resultSet.getString("userName"));
            user.setAge(resultSet.getString("age"));
            user.setBirthday(resultSet.getString("birthday"));
            user.setPassword(resultSet.getString("password"));
            return user;
        }
    }
}
