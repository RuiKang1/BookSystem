package cn.lanqiao.booksystem.modle.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class BookTypeInfo {

  private long tid;
  private String name;

  public long getTid() {
    return tid;
  }

  public void setTid(long tid) {
    this.tid = tid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BookTypeInfo(long tid, String name) {
    this.tid = tid;
    this.name = name;
  }

  public BookTypeInfo() {
  }
}
