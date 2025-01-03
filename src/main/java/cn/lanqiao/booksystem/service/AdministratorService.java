package cn.lanqiao.booksystem.service;

import cn.lanqiao.booksystem.modle.pojo.AdminInfo;

public interface AdministratorService {
    AdminInfo login(String operatorName, String operatorPass);
    boolean register(AdminInfo adminInfo);
}