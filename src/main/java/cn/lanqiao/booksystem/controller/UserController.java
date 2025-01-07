package cn.lanqiao.booksystem.controller;

import cn.hutool.core.util.IdUtil;
import cn.lanqiao.booksystem.modle.dto.UserInfoAdd;
import cn.lanqiao.booksystem.modle.dto.UserInfoQuery;
import cn.lanqiao.booksystem.modle.pojo.UserInfo;
import cn.lanqiao.booksystem.service.UserService;
import cn.lanqiao.booksystem.utils.ResponseUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private static final com.fasterxml.jackson.databind.ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 01.用户注册功能
     */
    @RequestMapping("/register")
    @ResponseBody
    public ResponseUtils register(@RequestBody UserInfoAdd userInfoAdd){
        try {
            int register = userService.register(userInfoAdd);
            if (register ==1){
                //注册成功
                return new ResponseUtils<>(1,"注册成功");
            }else {
                //注册失败
                return new ResponseUtils<>(2,"注册失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 02.用户登录功能
     * @param userInfoQuery
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public ResponseUtils login(@RequestBody UserInfoQuery userInfoQuery,HttpServletResponse response,HttpServletRequest request){
        try {
            //获取前端输入的验证码
            String code = userInfoQuery.getCode();
            //获取后端生成的验证码
            HttpSession session = request.getSession();
            String codes = session.getAttribute("codes").toString();


            UserInfo login = userService.login(userInfoQuery);
            if (login != null){
                if (code.equals(codes)){
                    if(userInfoQuery.isRememberPassword()){
                        //勾选了记住我
                        Cookie cookie1 = new Cookie("username", URLEncoder.encode(userInfoQuery.getUsername(), "UTF-8"));
                        Cookie cookie2 = new Cookie("password", URLEncoder.encode(userInfoQuery.getPassword(), "UTF-8"));
                        // 设置cookie的存活时间
                        cookie1.setMaxAge(60 * 60 * 24 * 7);
                        cookie2.setMaxAge(60 * 60 * 24 * 7);
                        // 设置cookie的路径，使其在整个应用中可用
                        cookie1.setPath("/");
                        cookie2.setPath("/");
                        // 如果使用HTTPS，可以设置secure属性
                        // cookie1.setSecure(true);
                        // cookie2.setSecure(true);
                        response.addCookie(cookie1);
                        response.addCookie(cookie2);
                    }else {
                        System.out.println(userInfoQuery.isRememberPassword());
                    }
                    //验证码正确，登录成功
                    return new ResponseUtils(1,"登录成功",login);
                }else {
                    //验证码错误
                    return new ResponseUtils<>(2,"验证码错误，登录失败");
                }
            }else {
                //登录失败
                return new ResponseUtils<>(2,"账号或密码错误，登录失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 退出用户登录功能
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
