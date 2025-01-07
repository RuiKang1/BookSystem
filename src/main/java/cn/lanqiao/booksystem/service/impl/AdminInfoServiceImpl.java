package cn.lanqiao.booksystem.service.impl;

import cn.lanqiao.booksystem.mapper.AdminInfoMapper;
import cn.lanqiao.booksystem.modle.pojo.AdminInfo;
import cn.lanqiao.booksystem.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminInfoServiceImpl implements AdminInfoService {
    @Autowired
    private AdminInfoMapper adminInfoMapper;

    /**
     * 管理员登录
     * @param adminInfo
     * @return
     */
    @Override
    public AdminInfo login(AdminInfo adminInfo) {

        try {
            AdminInfo login = adminInfoMapper.login(adminInfo);

            if (login != null){
                //登录成功
                return login;
            }else {
                //登录失败
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int register(AdminInfo adminInfo) {
        try {
            int register = adminInfoMapper.register(adminInfo);
            if (register > 0){
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
}
