package cn.lanqiao.booksystem.mapper;


import cn.lanqiao.booksystem.modle.pojo.BooksInfo;
import org.apache.ibatis.annotations.Mapper;

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
    List<BooksInfo> selectUserBorrow();

}




