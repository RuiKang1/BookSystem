package cn.lanqiao.booksystem.modle.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookReturnPojo {
    private Integer currentPage;
    private Integer currentSize;
    private String number;
    private String queryCriteria;


    @Override
    public String toString() {
        return "BookReturnPojo{" +
                "currentPage=" + currentPage +
                ", currentSize=" + currentSize +
                ", number='" + number + '\'' +
                ", queryCriteria='" + queryCriteria + '\'' +
                '}';
    }
}
