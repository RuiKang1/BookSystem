package cn.lanqiao.booksystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookMapper {
    List<String> getBookType();
}
