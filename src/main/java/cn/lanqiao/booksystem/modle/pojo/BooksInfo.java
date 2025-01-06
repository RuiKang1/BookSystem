package cn.lanqiao.booksystem.modle.pojo;

import java.sql.Date;

public class BooksInfo {

  private long bid;
  private String name;
  private String card;
  private String author;
  private long num;
  private String press;
  private String type;
  private long status;
  private String beginTime;
  private String endTime;

  @Override
  public String toString() {
    return "BooksInfo{" +
            "bid=" + bid +
            ", name='" + name + '\'' +
            ", card='" + card + '\'' +
            ", author='" + author + '\'' +
            ", num=" + num +
            ", press='" + press + '\'' +
            ", type='" + type + '\'' +
            ", status=" + status +
            ", beginTime='" + beginTime + '\'' +
            ", endTime='" + endTime + '\'' +
            '}';
  }

  public String getBeginTime() {
    return beginTime;
  }

  public void setBeginTime(String beginTime) {
    this.beginTime = beginTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public BooksInfo() {
  }

  public BooksInfo(long bid, String name, String card, String author, long num, String press, String type, long status, String beginTime, String endTime) {
    this.bid = bid;
    this.name = name;
    this.card = card;
    this.author = author;
    this.num = num;
    this.press = press;
    this.type = type;
    this.status = status;
    this.beginTime = beginTime;
    this.endTime = endTime;
  }

  public long getBid() {
    return bid;
  }

  public void setBid(long bid) {
    this.bid = bid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCard() {
    return card;
  }

  public void setCard(String card) {
    this.card = card;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public long getNum() {
    return num;
  }

  public void setNum(long num) {
    this.num = num;
  }

  public String getPress() {
    return press;
  }

  public void setPress(String press) {
    this.press = press;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }
}
