package com.mantou.service;

import com.mantou.entity.UserExport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    List<UserExport> exportAllUserInfo(String userName, String jobNum, String sex);
    int importUser(@Param("list") List<UserExport> list);
}
