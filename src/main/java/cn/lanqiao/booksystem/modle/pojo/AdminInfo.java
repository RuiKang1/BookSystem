package cn.lanqiao.booksystem.modle.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class AdminInfo {
  private Integer operatorId;
  private String operatorName;
  private String operatorPass;
}
