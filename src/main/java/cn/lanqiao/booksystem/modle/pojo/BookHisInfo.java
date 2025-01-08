package cn.lanqiao.booksystem.modle.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookHisInfo {

  private long hid;
  private long aid;
  private long bid;
  private String card;
  private String name;
  private String adminName;
  private String username;
  private Date beginTime;
  private Date endTime;
  private long status;

  @Override
  public String toString() {
    return "BookHisInfo{" +
            "hid=" + hid +
            ", aid=" + aid +
            ", bid=" + bid +
            ", card='" + card + '\'' +
            ", name='" + name + '\'' +
            ", adminName='" + adminName + '\'' +
            ", username='" + username + '\'' +
            ", beginTime='" + beginTime + '\'' +
            ", endTime='" + endTime + '\'' +
            ", status=" + status +
            '}';
  }

}
