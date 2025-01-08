package cn.lanqiao.booksystem.mapper;


import cn.lanqiao.booksystem.modle.dto.BookBorrowDTO;
import cn.lanqiao.booksystem.modle.pojo.BookHisInfo;
import cn.lanqiao.booksystem.modle.pojo.BooksInfo;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

/**
* @author 一坨盐巴
* @description 针对表【books_info】的数据库操作Mapper
* @createDate 2024-12-25 09:32:54
* @Entity generator.domain.BooksInfo
*/
@Mapper
public interface BooksInfoMapper{
    //用户书籍查询
    List<BooksInfo> selectUserBooks();
    //用户查询借阅信息
    List<BookHisInfo> selectBooksByName(String name, Integer page, Integer pageSize);
    List<BookHisInfo> selectBooksByCard(String card,Integer page,Integer pageSize);
    //借阅图书功能
    int borrow(@Param("userId") Long userId,@Param("bookHisInfo") BookHisInfo bookHisInfo);
    //
    int changeStatus(Long bid);
    //用户还书功能
    int returnBook(Long bid);
    //删除借阅信息根据书的id号
    int deleteInfo(Long bid);
}




