package cn.lanqiao.booksystem.mapper;

import cn.lanqiao.booksystem.modle.pojo.BookTypeInfo;
import cn.lanqiao.booksystem.modle.pojo.BooksInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    List<BookTypeInfo> getBookType();
    List<BooksInfo> selectBooksByName(String name);
    List<BooksInfo> selectBooksByAuthor(String author);
    List<BooksInfo> selectBooksByType(String type);
    List<BooksInfo> selectBooksByCard(String card);



    int addBook(BooksInfo book);
}
