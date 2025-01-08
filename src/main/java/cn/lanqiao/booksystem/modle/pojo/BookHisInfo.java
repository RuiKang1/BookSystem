package cn.lanqiao.booksystem.modle.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookHisInfo {
@TableId(type = IdType.AUTO)
  private long hid;
  private long aid;
  private long bid;
  @TableField("card")
  private String card;
  @TableField("name")
  private String name;
  @TableField("admin_name")
  private String adminName;
  @TableField("username")
  private String username;
  @JsonFormat(pattern = "YYYY-mm-DD")
  @TableField("begin_time")
  private Date beginTime;
  @JsonFormat(pattern = "YYYY-mm-DD")
  @TableField("end_time")
  private Date endTime;
  @TableField("status")
  private long status;
}
