package cn.lanqiao.booksystem.mapper;

import cn.lanqiao.booksystem.modle.pojo.BookTypeInfo;
import cn.lanqiao.booksystem.modle.pojo.BooksInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface BookMapper {
    List<BookTypeInfo> getBookType();
    List<BooksInfo> selectBooks();
}
