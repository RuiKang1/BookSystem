package cn.lanqiao.booksystem.service;


import cn.lanqiao.booksystem.modle.dto.BookBorrowDTO;
import cn.lanqiao.booksystem.modle.pojo.BookHisInfo;
import cn.lanqiao.booksystem.modle.pojo.BooksInfo;

import java.util.List;

/**
* @author 一坨盐巴
* @description 针对表【books_info】的数据库操作Service
* @createDate 2024-12-25 09:32:54
*/
public interface BooksInfoService{
    //用户书籍查询
    List<BooksInfo> selectUserBooks();
    //用户查询借阅信息
    List<BookHisInfo> selectBooksByName(String name, Integer page, Integer pageSize);
    List<BookHisInfo> selectBooksByCard(String card,Integer page,Integer pageSize);
    //借阅图书功能
    int borrow(Long bid);

    //用户还书功能
    int returnBook(Long bid);

}
