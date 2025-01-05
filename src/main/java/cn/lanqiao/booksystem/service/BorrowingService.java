package cn.lanqiao.booksystem.service;

import cn.lanqiao.booksystem.modle.pojo.BookTypeInfo;
import cn.lanqiao.booksystem.modle.pojo.BooksInfo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BorrowingService {
    List<BookTypeInfo> getBookType();
    List<BooksInfo> selectBooksByName(String name);
    List<BooksInfo> selectBooksByAuthor(String author);
    List<BooksInfo> selectBooksByType(String type);
    List<BooksInfo> selectBooksByCard(String card);
}
