package cn.lanqiao.booksystem.modle.pojo;
public class BookTypeInfo {

  private int tid;
  private String name;
  private int del;

  public int getTid() {
    return tid;
  }

  public void setTid(int tid) {
    this.tid = tid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getDel() {
    return del;
  }

  public void setDel(int del) {
    this.del = del;
  }

  public BookTypeInfo(int tid, String name, int del) {
    this.tid = tid;
    this.name = name;
    this.del = del;
  }

  public BookTypeInfo() {
  }
}
