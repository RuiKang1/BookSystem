package cn.lanqiao.booksystem.service;

import cn.lanqiao.booksystem.modle.pojo.BookTypeInfo;
import cn.lanqiao.booksystem.modle.pojo.BooksInfo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    List<BookTypeInfo> getBookType();
    List<BooksInfo> selectBooks();
}
