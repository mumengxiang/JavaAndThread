package shiro.dao.base;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import shiro.domain.User;

import java.util.List;

@Mapper
public interface UserDO {

    @Select("select * from user where username='${inName}' ")
    List<User> getPwdByName(@Param("inName") String inName);
}
