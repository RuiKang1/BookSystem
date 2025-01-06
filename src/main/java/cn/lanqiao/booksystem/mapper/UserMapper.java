package cn.lanqiao.booksystem.mapper;

import cn.lanqiao.booksystem.modle.dto.UserInfoAdd;
import cn.lanqiao.booksystem.modle.dto.UserInfoQuery;
import cn.lanqiao.booksystem.modle.pojo.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
//    用户注册
    /**
     * 注册功能
     */
    int register(UserInfoAdd userInfoAdd);
    /**
     * 登录功能
     */

    UserInfo login(UserInfoQuery userInfoQuery);


}
