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
     * 01.注册功能
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


    @PostMapping("/login")
    @ResponseBody
    public ResponseUtils login(@RequestBody UserInfoQuery userInfoQuery){
        try {
            UserInfo login = userService.login(userInfoQuery);
            if (login != null){
                //登录成功
                return new ResponseUtils(1,"登录成功",login);
            }else {
                //登录失败
                return new ResponseUtils<>(2,"登录失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
