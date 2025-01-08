package cn.lanqiao.booksystem.service;

import cn.lanqiao.booksystem.modle.pojo.BookHisInfo;
import cn.lanqiao.booksystem.modle.pojo.BookReturnPojo;

import java.util.List;

public interface BookReturnService {
    List<BookHisInfo> selectData(BookReturnPojo bookReturnPojo);
    List<BookHisInfo> selectDataByBookName(BookReturnPojo bookReturnPojo);
    List<BookHisInfo> selectDataByUsername(BookReturnPojo bookReturnPojo);
    List<BookHisInfo> selectDataByCard(BookReturnPojo bookReturnPojo);

    int delete(Integer id);
}
