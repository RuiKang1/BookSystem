package cn.lanqiao.booksystem.service.impl;

import cn.lanqiao.booksystem.mapper.BookMapper;
import cn.lanqiao.booksystem.mapper.BorrowingMapper;
import cn.lanqiao.booksystem.modle.pojo.BookTypeInfo;
import cn.lanqiao.booksystem.modle.pojo.BooksInfo;
import cn.lanqiao.booksystem.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowingServiceImpl implements BorrowingService {
    @Autowired
    private BorrowingMapper borrowingMapper;


    @Override
    public List<BookTypeInfo> getBookType() {
        List<BookTypeInfo> bookType = borrowingMapper.getBookType();
        if(bookType != null){
            return bookType;
        }else{
            return null;
        }
    }

    @Override
    public List<BooksInfo> selectBooksByName(String name) {
        List<BooksInfo> booksInfos = borrowingMapper.selectBooksByName(name);
        if(booksInfos != null){
            return booksInfos;
        }else{
            return null;
        }
    }

    @Override
    public List<BooksInfo> selectBooksByType(String type) {
        List<BooksInfo> booksInfos = borrowingMapper.selectBooksByType(type);
        if(booksInfos != null){
            return booksInfos;
        }else{
            return null;
        }
    }

    @Override
    public List<BooksInfo> selectBooksByAuthor(String author) {
        List<BooksInfo> booksInfos = borrowingMapper.selectBooksByAuthor(author);
        if(booksInfos != null){
            return booksInfos;
        }else{
            return null;
        }
    }



    @Override
    public List<BooksInfo> selectBooksByCard(String card) {
        List<BooksInfo> booksInfos = borrowingMapper.selectBooksByCard(card);
        if(booksInfos != null){
            return booksInfos;
        }else{
            return null;
        }
    }
}
