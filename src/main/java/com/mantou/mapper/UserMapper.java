package com.mantou.mapper;


import com.mantou.entity.UserExport;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UserMapper {
    //导出用户信息
    @Select("<script>" +
            "SELECT u.id,u.username,u.jobnum,CASE u.sex WHEN '1' THEN '男' ELSE '女' END AS sex ,r.rolename from user u,role r WHERE u.roleid = r.id "
            +"<if test='userName != null '> and username like '%${userName}%' </if>"
            +"<if test='jobNum != null '> and jobnum like '%${jobNum}%' </if>"
            +"<if test='sex != 2'> and sex = '${sex}' </if>"
            +"</script>")
    List<UserExport> exportAllUserInfo(String userName,String jobNum,String sex);
    //导入用户信息
    @Select("<script>"
            +"INSERT INTO user (username,jobnum) "
            + "VALUES"
            +"<foreach collection='list' item='user' separator=','>"
            +"(#{user.userName},#{user.jobNum})"
            +"</foreach>"
            +"</script>")
    Integer importUser(@Param("list") List<UserExport> list);
}
