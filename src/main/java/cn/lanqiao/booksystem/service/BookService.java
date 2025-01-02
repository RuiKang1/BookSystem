package cn.lanqiao.booksystem.service;

import cn.lanqiao.booksystem.modle.pojo.BookTypeInfo;
import cn.lanqiao.booksystem.modle.pojo.BooksInfo;

import java.util.List;

public interface BookService {
    List<BookTypeInfo> getBookType();
    List<BooksInfo> selectBooksByName(String name);
    List<BooksInfo> selectBooksByAuthor(String author);
    List<BooksInfo> selectBooksByType(String type);
    List<BooksInfo> selectBooksByCard(String card);

    int addBook(BooksInfo book);
    int editBookInfo(BooksInfo book);
    int deleteBooks(List<Integer> bids);
}
