package cn.lanqiao.booksystem.modle.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminInfo {
  private long operatorId;
  private String operatorName;
  private String operatorPass;
}
