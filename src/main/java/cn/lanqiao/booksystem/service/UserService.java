package cn.lanqiao.booksystem.service;

import cn.lanqiao.booksystem.modle.dto.UserInfoAdd;
import cn.lanqiao.booksystem.modle.dto.UserInfoQuery;
import cn.lanqiao.booksystem.modle.pojo.UserInfo;

public interface UserService {
    /**
     * 注册功能
     */
    int register(UserInfoAdd userInfoAdd);
    /**
     * 登录功能
     */
    UserInfo login(UserInfoQuery userInfoQuery);
}
