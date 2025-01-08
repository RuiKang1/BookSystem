package cn.lanqiao.booksystem.modle.vo;

import cn.lanqiao.booksystem.modle.pojo.BookHisInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookHisInfoVO {
    private Long total;
    private List<BookHisInfo> currentPage;
}
