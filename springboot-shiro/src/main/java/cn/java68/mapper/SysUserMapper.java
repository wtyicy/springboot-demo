package cn.java68.mapper;


import cn.java68.model.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper {

    /**
     * 查找用户
     * @param user
     * @return
     */
    SysUser findUser(SysUser user);
}
