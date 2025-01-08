package cn.lanqiao.booksystem.service.impl;

import cn.lanqiao.booksystem.mapper.BookReturnMapper;
import cn.lanqiao.booksystem.modle.pojo.BookHisInfo;
import cn.lanqiao.booksystem.modle.pojo.BookReturnPojo;
import cn.lanqiao.booksystem.service.BookReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookReturnServiceImpl implements BookReturnService {
    @Autowired
    private BookReturnMapper bookReturnMapper;

    @Override
    public List<BookHisInfo> selectData(BookReturnPojo bookReturnPojo) {
        int finallyPage = (bookReturnPojo.getCurrentPage() - 1) * bookReturnPojo.getCurrentSize();
        List<BookHisInfo> bookHisInfos = bookReturnMapper.selectData(bookReturnPojo,finallyPage);
        return bookHisInfos;
    }

    @Override
    public List<BookHisInfo> selectDataByBookName(BookReturnPojo bookReturnPojo) {
        int finallyPage = (bookReturnPojo.getCurrentPage() - 1) * bookReturnPojo.getCurrentSize();
        List<BookHisInfo> bookHisInfos = bookReturnMapper.selectDataByBookName(bookReturnPojo,finallyPage);
        return bookHisInfos;
    }

    @Override
    public List<BookHisInfo> selectDataByUsername(BookReturnPojo bookReturnPojo) {
        int finallyPage = (bookReturnPojo.getCurrentPage() - 1) * bookReturnPojo.getCurrentSize();
        List<BookHisInfo> bookHisInfos = bookReturnMapper.selectDataByUsername(bookReturnPojo,finallyPage);
        return bookHisInfos;
    }

    @Override
    public List<BookHisInfo> selectDataByCard(BookReturnPojo bookReturnPojo) {
        int finallyPage = (bookReturnPojo.getCurrentPage() - 1) * bookReturnPojo.getCurrentSize();
        List<BookHisInfo> bookHisInfos = bookReturnMapper.selectDataByCard(bookReturnPojo,finallyPage);
        return bookHisInfos;
    }

    @Override
    public int delete(Integer id) {
        int result = bookReturnMapper.delete(id);
        if(result > 0){
            return 1;
        }else {
            return 0;
        }
    }
}
