package cn.lanqiao.booksystem.controller;

import cn.lanqiao.booksystem.modle.pojo.AdminInfo;
import cn.lanqiao.booksystem.service.AdministratorService;
import cn.lanqiao.booksystem.utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminInfoController {

    // 明确指定使用 org.slf4j.Logger
    private static final Logger logger = LoggerFactory.getLogger(AdminInfoController.class);

    @Autowired
    private AdministratorService administratorService;

    @PostMapping("/login")
    public ResponseEntity<ResponseUtils<AdminInfo>> login(@RequestBody AdminInfo adminInfo) {
        try {
            AdminInfo user = administratorService.login(adminInfo.getOperatorName(), adminInfo.getOperatorPass());
            if (user != null) {
                // 实际应用中应该使用JWT或Session管理
                return ResponseEntity.ok(new ResponseUtils<>(HttpStatus.OK.value(), "登录成功", user));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(new ResponseUtils<>(HttpStatus.UNAUTHORIZED.value(), "无效的凭证"));
            }
        } catch (Exception e) {
            // 记录异常日志
            logger.error("Login failed: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseUtils<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器内部错误"));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseUtils<AdminInfo>> register(@RequestBody AdminInfo adminInfo) {
        try {
            if (administratorService.register(adminInfo)) {
                return ResponseEntity.ok(new ResponseUtils<>(HttpStatus.CREATED.value(), "注册成功"));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_MODIFIED)
                        .body(new ResponseUtils<>(HttpStatus.NOT_MODIFIED.value(), "注册失败"));
            }
        } catch (Exception e) {
            // 记录异常日志
            logger.error("Registration failed: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseUtils<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器内部错误"));
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout() {
        try {
            // 实现退出逻辑，比如清除session或token
            // 这里假设已经实现了相应的逻辑
            return ResponseEntity.ok("登出成功");
        } catch (Exception e) {
            // 记录异常日志
            logger.error("Logout failed: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("服务器内部错误");
        }
    }
}