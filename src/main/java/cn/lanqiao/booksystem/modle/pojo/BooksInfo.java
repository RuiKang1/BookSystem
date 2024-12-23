package cn.lanqiao.booksystem.modle.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BooksInfo {

  private long bid;
  private String name;
  private String card;
  private String author;
  private long num;
  private String press;
  private String type;
  private long status;

}
