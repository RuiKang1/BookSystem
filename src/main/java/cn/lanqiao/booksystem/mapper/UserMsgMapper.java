package cn.lanqiao.booksystem.mapper;

import cn.lanqiao.booksystem.modle.pojo.BooksInfo;
import cn.lanqiao.booksystem.modle.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMsgMapper {
    List<UserInfo> selectUserByUsername(String username, Integer page, Integer pageSize);
    List<UserInfo> selectUserByName(String name, Integer page, Integer pageSize);

    int editUserInfo(UserInfo user);
    int deleteUsers(List<Integer> aids);
}
