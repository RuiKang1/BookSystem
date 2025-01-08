package cn.lanqiao.booksystem.mapper;

import cn.lanqiao.booksystem.modle.pojo.AdminInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminInfoMapper {
    /**
     * 管理员登录
     */
    AdminInfo login(AdminInfo adminInfo);

    /**
     * 管理员注册
     */
    int register(AdminInfo adminInfo);

}
