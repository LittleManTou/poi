package com.mantou.serviceImpl;

import com.mantou.entity.UserExport;
import com.mantou.mapper.UserMapper;
import com.mantou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<UserExport> exportAllUserInfo(String userName, String jobNum, String sex) {
        return userMapper.exportAllUserInfo(userName,jobNum,sex);
    }

    @Override
    public int importUser(List<UserExport> list) {
        return userMapper.importUser(list);
    }
}
