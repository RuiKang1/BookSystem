package cn.lanqiao.booksystem.service.impl;

import cn.lanqiao.booksystem.mapper.AdministratorMapper;
import cn.lanqiao.booksystem.modle.pojo.AdminInfo;
import cn.lanqiao.booksystem.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class AdministratorServiceImpl implements AdministratorService {



    @Autowired
    private AdministratorMapper administratorMapper;

    public AdminInfo login(String operatorName, String operatorPass) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        AdminInfo user = administratorMapper.getAdminByUserName(operatorName,operatorPass);
        if (user != null && encoder.matches(operatorPass, user.getOperatorPass())) {
            return user;
        }
        return null;
    }

    public boolean register(AdminInfo adminInfo) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        adminInfo.setOperatorPass(encoder.encode(adminInfo.getOperatorPass()));
        return administratorMapper.registerAdmin(adminInfo) > 0;
    }
}