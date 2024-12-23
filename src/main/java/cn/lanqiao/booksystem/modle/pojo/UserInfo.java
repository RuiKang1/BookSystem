package cn.lanqiao.booksystem.modle.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

  private long aid;
  private String username;
  private String name;
  private String password;
  private String email;
  private String phone;
  private long status;
  private long lendNum;
  private long maxNum;

}
