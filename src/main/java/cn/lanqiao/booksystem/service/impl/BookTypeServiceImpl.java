package cn.lanqiao.booksystem.service.impl;

import cn.lanqiao.booksystem.mapper.BookTypeMapper;
import cn.lanqiao.booksystem.modle.pojo.BookTypeInfo;
import cn.lanqiao.booksystem.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookTypeServiceImpl implements BookTypeService {

    @Autowired
    private BookTypeMapper bookTypeMapper;

    /**
     * 查询所以书籍分类
     * @return
     */
    @Override
    public List<BookTypeInfo> selectTypeAll() {
        try {
            List<BookTypeInfo> bookTypeInfos = bookTypeMapper.selectTypeAll();

            if (bookTypeInfos != null){
                return bookTypeInfos;
            }else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delType(int tid) {
        try {
            int del = bookTypeMapper.delType(tid);
            if (del > 0){
                return 1;
            }else {
                return 0;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
