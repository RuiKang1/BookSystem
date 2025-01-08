package cn.lanqiao.booksystem.service.impl;


import cn.lanqiao.booksystem.mapper.BookMapper;
import cn.lanqiao.booksystem.modle.dto.BookBorrowDTO;
import cn.lanqiao.booksystem.modle.pojo.BookHisInfo;
import cn.lanqiao.booksystem.modle.pojo.BooksInfo;
import cn.lanqiao.booksystem.service.BooksInfoService;
import cn.lanqiao.booksystem.mapper.BooksInfoMapper;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author 一坨盐巴
* @description 针对表【books_info】的数据库操作Service实现
* @createDate 2024-12-25 09:32:54
*/
@Service
public class BooksInfoServiceImpl implements BooksInfoService{
    @Autowired
    private BooksInfoMapper booksInfoMapper;
    @Override
    public List<BooksInfo> selectUserBooks() {
        List<BooksInfo> booksInfos = booksInfoMapper.selectUserBooks();
        if(booksInfos != null){
            return booksInfos;
        }else{
            return null;
        }
    }

    @Override
    public List<BookHisInfo> selectBooksByName(String name, Integer page, Integer pageSize) {
        int finallyPage = (page - 1) * pageSize;
        List<BookHisInfo> booksHisInfos = booksInfoMapper.selectBooksByName(name,finallyPage,pageSize);
        if(booksHisInfos != null){
            return booksHisInfos;
        }else{
            return null;
        }
    }

    @Override
    public List<BookHisInfo> selectBooksByCard(String card, Integer page, Integer pageSize) {
        int finallyPage = (page - 1) * pageSize;
        List<BookHisInfo> booksHisInfos = booksInfoMapper.selectBooksByCard(card,finallyPage,pageSize);
        if(booksHisInfos != null){
            return booksHisInfos;
        }else{
            return null;
        }
    }

    @Override
    public int borrow(Long userId,BookHisInfo bookHisInfo,Long bid,String card,String name,Date beginTime, Date endTime) {
        int result = booksInfoMapper.borrow(userId,bookHisInfo,bid,card,name, (java.sql.Date) beginTime, (java.sql.Date) endTime);
        if (result>0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public int changeStatus(Long bid) {
        int result = booksInfoMapper.changeStatus(bid);
        if (result>0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public int returnBook(Long bid) {
        int result = booksInfoMapper.returnBook(bid);
        if (result>0){
            return 1;
        }else {
            return 0;
        }
    }
}




