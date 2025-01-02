package cn.lanqiao.booksystem.service.impl;

import cn.lanqiao.booksystem.mapper.BookMapper;
import cn.lanqiao.booksystem.modle.pojo.BookTypeInfo;
import cn.lanqiao.booksystem.modle.pojo.BooksInfo;
import cn.lanqiao.booksystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<BookTypeInfo> getBookType() {
        List<BookTypeInfo> bookType = bookMapper.getBookType();
        if(bookType != null){
            return bookType;
        }else{
            return null;
        }
    }

    @Override
    public List<BooksInfo> selectBooks() {
        List<BooksInfo> booksInfos = bookMapper.selectBooks();
        if(booksInfos != null){
            return booksInfos;
        }else{
            return null;
        }
    }

    @Override
    public int addBook(BooksInfo book) {
        int result = bookMapper.addBook(book);
        if(result > 0){
            return 1;
        }else{
            return 0;
        }
    }
}
