package cn.lanqiao.booksystem.mapper;

import cn.lanqiao.booksystem.modle.pojo.BookHisInfo;
import cn.lanqiao.booksystem.modle.pojo.BookReturnPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface BookReturnMapper {
    List<BookHisInfo> selectData(@Param("bookReturn") BookReturnPojo bookReturnPojo,@Param("page") int finalPage);
    List<BookHisInfo> selectDataByBookName(@Param("bookReturn") BookReturnPojo bookReturnPojo,@Param("page") int finalPage);
    List<BookHisInfo> selectDataByUsername(@Param("bookReturn") BookReturnPojo bookReturnPojo,@Param("page") int finalPage);
    List<BookHisInfo> selectDataByCard(@Param("bookReturn") BookReturnPojo bookReturnPojo,@Param("page") int finalPage);

    int delete(Integer id);

}
