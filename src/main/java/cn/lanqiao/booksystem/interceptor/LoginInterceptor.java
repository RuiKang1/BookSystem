package cn.lanqiao.booksystem.interceptor;



import cn.lanqiao.booksystem.modle.pojo.AdminInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求URI并记录日志
        String requestURI = request.getRequestURI();
        log.info("Request URI: {}", requestURI);

        // 检查是否为不需要拦截的路径（如登录、注册页面）
        if (isPublicResource(requestURI)) {
            return true;
        }

        // 从请求头中获取token
        String token = request.getHeader("token");
        log.info("Received Token: {}", token);

        // 如果token为空，则返回未授权响应或重定向到登录页面
        if (token == null || token.isEmpty()) {
            handleUnauthorized(response);
            return false;
        }

        // 尝试从会话中获取用户登录信息
        HttpSession session = request.getSession(false); // 不创建新会话
        AdminInfo userLogin = (session != null) ? (AdminInfo) session.getAttribute("userLogin") : null;
        log.info("User Login Info: {}", userLogin);

        // 如果用户信息不存在于会话中，或者与Redis中的Token不匹配，则拒绝访问
        if (userLogin == null || !validateToken(userLogin.getOperatorName(), token)) {
            handleUnauthorized(response);
            return false;
        }

        // 更新Token的有效期
        extendTokenExpiration(userLogin.getOperatorName());

        // 用户已登录且Token有效，继续处理请求
        return true;
    }

    /**
     * 判断请求的资源是否是公共资源（无需拦截）
     */
    private boolean isPublicResource(String uri) {
        // 定义不需要拦截的URL模式
        String[] publicResources = {"/admin/login", "/admin/register"};
        for (String resource : publicResources) {
            if (uri.endsWith(resource)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 验证Token是否存在于Redis中并与给定的Token相匹配
     */
    private boolean validateToken(String username, String token) {
        String usrToken = stringRedisTemplate.opsForValue().get("lanqiao:token:" + username);
        log.info("Redis Token: {}", usrToken);
        return usrToken != null && usrToken.equals(token);
    }

    /**
     * 延长Token在Redis中的有效期
     */
    private void extendTokenExpiration(String username) {
        stringRedisTemplate.expire("lanqiao:token:" + username, 30L, TimeUnit.MINUTES);
    }

    /**
     * 处理未授权的情况，返回JSON错误信息或重定向到登录页面
     */
    private void handleUnauthorized(HttpServletResponse response) throws Exception {
        // 根据请求类型决定响应方式
        if (response.getHeader("Accept").contains("application/json")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"error\":\"Unauthorized\"}");
        } else {
            // 对于HTML页面请求，重定向到登录页面
            response.sendRedirect("/admin/login"); // 替换成实际的登录页面路径
        }
    }
}
