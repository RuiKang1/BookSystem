package cn.lanqiao.booksystem.service.impl;


import cn.lanqiao.booksystem.mapper.BookMapper;
import cn.lanqiao.booksystem.modle.dto.BookBorrowDTO;
import cn.lanqiao.booksystem.modle.pojo.BooksInfo;
import cn.lanqiao.booksystem.service.BooksInfoService;
import cn.lanqiao.booksystem.mapper.BooksInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<BookBorrowDTO> selectUserBorrow() {
        return booksInfoMapper.selectUserBorrow();
    }

    @Override
    public int borrow(Long bid) {
        int result = booksInfoMapper.borrow(bid);
        if (result>0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public int returnBook(Long hid) {
        int result = booksInfoMapper.returnBook(hid);
        if (result>0){
            return 1;
        }else {
            return 0;
        }
    }
}




