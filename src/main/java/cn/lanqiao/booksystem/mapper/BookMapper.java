package cn.lanqiao.booksystem.mapper;

import cn.lanqiao.booksystem.modle.pojo.BookTypeInfo;
import cn.lanqiao.booksystem.modle.pojo.BooksInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    List<BookTypeInfo> getBookType();
    List<BooksInfo> selectBooksByName(String name,Integer page,Integer pageSize);
    List<BooksInfo> selectBooksByAuthor(String author,Integer page,Integer pageSize);
    List<BooksInfo> selectBooksByType(String type,Integer page,Integer pageSize);
    List<BooksInfo> selectBooksByCard(String card,Integer page,Integer pageSize);

    int addBook(BooksInfo book);
    int editBookInfo(BooksInfo book);
    int deleteBooks(List<Integer> bids);
}
