package cn.lanqiao.booksystem.service;

import cn.lanqiao.booksystem.modle.pojo.BookTypeInfo;
import cn.lanqiao.booksystem.modle.pojo.BooksInfo;

import java.util.List;

public interface BookService {
    List<BookTypeInfo> getBookType();
    List<BooksInfo> selectBooksByName(String name,Integer page,Integer pageSize);
    List<BooksInfo> selectBooksByAuthor(String author,Integer page,Integer pageSize);
    List<BooksInfo> selectBooksByType(String type,Integer page,Integer pageSize);
    List<BooksInfo> selectBooksByCard(String card,Integer page,Integer pageSize);

    int addBook(BooksInfo book);
    int editBookInfo(BooksInfo book);
    int deleteBooks(List<Integer> bids);
}
