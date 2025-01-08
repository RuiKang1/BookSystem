package cn.lanqiao.booksystem.controller;


import cn.hutool.core.collection.SpliteratorUtil;
import cn.lanqiao.booksystem.modle.pojo.AdminInfo;
import cn.lanqiao.booksystem.service.AdminInfoService;
import cn.lanqiao.booksystem.utils.ResponseUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;

@RestController
@RequestMapping("/admin")
public class AdminInfoController {
    @Autowired
    private AdminInfoService adminInfoService;

    /**
     * 管理员登录
     * @param adminInfo
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public ResponseUtils login(@RequestBody AdminInfo adminInfo, HttpServletResponse response, HttpServletRequest request){
        try {
            AdminInfo login = adminInfoService.login(adminInfo);
            if (login != null){
                Cookie cookie = new Cookie("id", URLEncoder.encode(String.valueOf(adminInfo.getOperatorId()),"UTF-8"));
                //设置cookie存活时间
                cookie.setMaxAge(60 * 60 * 24 * 7);
                // 设置cookie的路径，使其在整个应用中可用
                cookie.setPath("/");
                response.addCookie(cookie);
                return new ResponseUtils<>(1,"登录成功",login);
            }else {
                return new ResponseUtils<>(2,"登录失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/register")
    @ResponseBody
    public ResponseUtils register(@RequestBody AdminInfo adminInfo){
        try {
            int register = adminInfoService.register(adminInfo);
            if (register == 1){
                //注册成功
                return new ResponseUtils<>(1,"注册成功");
            }else {
                //注册失败
                return new ResponseUtils(2,"注册失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 退出管理员登录功能
     * @param response
     * @param request
     * @return
     */
    @RequestMapping("/logout")
    @ResponseBody
    public ResponseUtils logout(HttpServletResponse response, HttpServletRequest request){
        try {
            // 获取所有 cookies
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("id".equals(cookie.getName())) {
                        // 清除 id cookie
                        cookie.setValue(null); // 将 cookie 的值置空
                        cookie.setMaxAge(0); // 设置 cookie 过期时间为 0，立即删除
                        cookie.setPath("/"); // 确保 cookie 在整个应用中有效
                        response.addCookie(cookie); // 添加到响应中，删除 cookie
                    }
                }
            }

            // 可以选择清除 Session 或其他认证信息
            // request.getSession().invalidate(); // 例如清除当前会话

            return new ResponseUtils<>(1, "退出成功");

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils<>(0, "退出失败");
        }
    }
}
