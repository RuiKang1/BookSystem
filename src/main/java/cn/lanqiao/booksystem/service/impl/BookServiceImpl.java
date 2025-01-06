package cn.lanqiao.booksystem.service.impl;

import cn.lanqiao.booksystem.mapper.BookMapper;
import cn.lanqiao.booksystem.modle.pojo.BookTypeInfo;
import cn.lanqiao.booksystem.modle.pojo.BooksInfo;
import cn.lanqiao.booksystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<BooksInfo> selectBooksByName(String name) {
        List<BooksInfo> booksInfos = bookMapper.selectBooksByName(name);
        if(booksInfos != null){
            return booksInfos;
        }else{
            return null;
        }
    }

    @Override
    public List<BooksInfo> selectBooksByType(String type) {
        List<BooksInfo> booksInfos = bookMapper.selectBooksByType(type);
        if(booksInfos != null){
            return booksInfos;
        }else{
            return null;
        }
    }

    @Override
    public List<BooksInfo> selectBooksByAuthor(String author) {
        List<BooksInfo> booksInfos = bookMapper.selectBooksByAuthor(author);
        if(booksInfos != null){
            return booksInfos;
        }else{
            return null;
        }
    }



    @Override
    public List<BooksInfo> selectBooksByCard(String card) {
        List<BooksInfo> booksInfos = bookMapper.selectBooksByCard(card);
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

    @Override
    public int editBookInfo(BooksInfo book) {
        int result = bookMapper.editBookInfo(book);
        if(result > 0){
            return 1;
        }else{
            return 0;
        }
    }

    @Transactional
    @Override
    public int deleteBooks(List<Integer> bids) {
        int result = bookMapper.deleteBooks(bids);
        if(result > 0){
            return 1;
        }else{
            return 0;
        }
    }
}
