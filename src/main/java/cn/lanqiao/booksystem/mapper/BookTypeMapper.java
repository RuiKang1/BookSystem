package cn.lanqiao.booksystem.mapper;

import cn.lanqiao.booksystem.modle.pojo.BookTypeInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookTypeMapper {
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
