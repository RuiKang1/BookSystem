package cn.lanqiao.booksystem.service;


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
    List<BooksInfo> selectUserBorrow();
}
