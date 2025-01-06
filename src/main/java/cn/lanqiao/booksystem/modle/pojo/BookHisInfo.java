package cn.lanqiao.booksystem.modle.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookHisInfo {

  private long hid;
  private long aid;
  private long bid;
  private String card;
  private String bookName;
  private String adminName;
  private String username;
  private String beginTime;
  private String endTime;
  private long status;




}
