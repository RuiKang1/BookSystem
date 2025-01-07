package cn.lanqiao.booksystem.modle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoQuery {
    private long aid;
    private String username;
    private String name;
    private String password;
    private String email;
    private String phone;
    private long status;
    private long lendNum;
    private long maxNum;

    private String code;//前端输入的验证码
    private boolean RememberPassword;


}
