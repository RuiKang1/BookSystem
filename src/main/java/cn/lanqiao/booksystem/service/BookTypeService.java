package cn.lanqiao.booksystem.service;

import cn.lanqiao.booksystem.modle.pojo.BookTypeInfo;

import java.util.List;

public interface BookTypeService {
    /**
     * 查询所有书籍类型
     */
    List<BookTypeInfo> selectTypeAll();

    /**
     * 新增分类
     */
    int insertType(BookTypeInfo bookTypeInfo);

    /**
     * 删除功能
     */
    int delType(int tid);

}
