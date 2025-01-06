package cn.lanqiao.booksystem.service;

import cn.lanqiao.booksystem.modle.pojo.AdminInfo;

public interface AdminInfoService {
    /**
     * 管理员登录
     */
    AdminInfo login(AdminInfo adminInfo);

    /**
     * 管理员注册
     */
    int register(AdminInfo adminInfo);
}
