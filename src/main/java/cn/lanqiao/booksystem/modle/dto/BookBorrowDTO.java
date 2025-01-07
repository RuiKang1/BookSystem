package cn.lanqiao.booksystem.modle.dto;

import java.util.Date;
import lombok.Data;

@Data
public class BookBorrowDTO {
    private Long bid;
    private String name;
    private String card;
    private String author;
    private Long num;
    private String press;
    private String type;
    private Long status;
    private Date beginTime;
    private Date endTime;
    private Long hid;  // 借阅历史ID
}