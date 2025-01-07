package cn.lanqiao.booksystem.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * 分页工具类
 * @param <T>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageHelper<T> {
    private int pageSize;//一页显示多少条
    private int counts;//总页数
    private int page;//当前页
    private List<T> list;//数据
}
