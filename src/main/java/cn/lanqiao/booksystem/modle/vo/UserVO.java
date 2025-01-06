package cn.lanqiao.booksystem.modle.vo;

import lombok.Data;

//vo就是响应给前端的对象，你想要响应给前端什么数据就写哪些属性就好了
@Data
public class UserVO {
    private long id;
    private String username;
    private String password;
    private String nickname;
    private String token;
}
