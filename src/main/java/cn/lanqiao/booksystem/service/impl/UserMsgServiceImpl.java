package cn.lanqiao.booksystem.service.impl;

import cn.lanqiao.booksystem.mapper.UserMsgMapper;
import cn.lanqiao.booksystem.modle.pojo.UserInfo;
import cn.lanqiao.booksystem.service.UserMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserMsgServiceImpl implements UserMsgService {
    @Autowired
    private UserMsgMapper userMsgMapper;

    @Override
    public List<UserInfo> selectUserByUsername(String username, Integer page, Integer pageSize) {
        int finallyPage = (page - 1) * pageSize;
        List<UserInfo> userInfos = userMsgMapper.selectUserByUsername(username,finallyPage,pageSize);
        if(userInfos != null){
            return userInfos;
        }else{
            return null;
        }
    }

    @Override
    public List<UserInfo> selectUserByName(String name, Integer page, Integer pageSize) {
        int finallyPage = (page - 1) * pageSize;
        List<UserInfo> userInfos = userMsgMapper.selectUserByName(name,finallyPage,pageSize);
        if(userInfos != null){
            return userInfos;
        }else{
            return null;
        }
    }

    @Override
    public int editUserInfo(UserInfo user) {
        int result = userMsgMapper.editUserInfo(user);
        if(result > 0){
            return 1;
        }else{
            return 0;
        }
    }

    @Transactional
    @Override
    public int deleteUsers(List<Integer> aids) {
        int result = userMsgMapper.deleteUsers(aids);
        if(result > 0){
            return 1;
        }else{
            return 0;
        }
    }
}
