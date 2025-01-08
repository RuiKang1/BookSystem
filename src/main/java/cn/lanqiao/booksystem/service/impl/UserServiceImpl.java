package cn.lanqiao.booksystem.service.impl;

import cn.lanqiao.booksystem.mapper.UserMapper;
import cn.lanqiao.booksystem.modle.dto.UserInfoAdd;
import cn.lanqiao.booksystem.modle.dto.UserInfoQuery;
import cn.lanqiao.booksystem.modle.pojo.UserInfo;
import cn.lanqiao.booksystem.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public int register(UserInfoAdd userInfo) {
        try {
            int result = userMapper.register(userInfo);
            if(result>0){
                //注册成功
                return 1;
            }else {
                //注册失败
                return 0;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserInfo login(UserInfoQuery userInfoQuery) {
        UserInfo result = userMapper.login(userInfoQuery);
        if(result != null){
            //登录成功
            return result;
        }else {
            //登录失败
            return null;
        }
    }
}
