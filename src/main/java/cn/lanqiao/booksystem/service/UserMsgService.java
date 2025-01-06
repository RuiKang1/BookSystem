package cn.lanqiao.booksystem.service;

import cn.lanqiao.booksystem.modle.pojo.UserInfo;

import java.util.List;

public interface UserMsgService {
    List<UserInfo> selectUserByUsername(String username, Integer page, Integer pageSize);
    List<UserInfo> selectUserByName(String name, Integer page, Integer pageSize);

    int editUserInfo(UserInfo user);
    int deleteUsers(List<Integer> aids);
}
