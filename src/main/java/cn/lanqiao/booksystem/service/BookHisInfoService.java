package cn.lanqiao.booksystem.service;

import cn.lanqiao.booksystem.modle.dto.BookHisInfoDTO;
import cn.lanqiao.booksystem.modle.pojo.BookHisInfo;
import cn.lanqiao.booksystem.modle.vo.BookHisInfoVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface BookHisInfoService extends IService<BookHisInfo> {
    BookHisInfoVO selectList(BookHisInfoDTO bookHisInfoDTO);
}
