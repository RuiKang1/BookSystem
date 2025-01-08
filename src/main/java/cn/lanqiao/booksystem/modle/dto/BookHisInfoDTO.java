package cn.lanqiao.booksystem.modle.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookHisInfoDTO {
    private Integer currentPage;
    private Integer currentSize;
    private String  queryCriteria;
    private int number;
}
