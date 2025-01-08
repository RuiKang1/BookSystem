package cn.lanqiao.booksystem.service.impl;

import cn.lanqiao.booksystem.common.SelectFactory;
import cn.lanqiao.booksystem.mapper.BookHisInfoMapper;
import cn.lanqiao.booksystem.modle.dto.BookHisInfoDTO;
import cn.lanqiao.booksystem.modle.pojo.BookHisInfo;
import cn.lanqiao.booksystem.modle.vo.BookHisInfoVO;
import cn.lanqiao.booksystem.service.BookHisInfoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookHisInfoServiceImpl extends ServiceImpl<BookHisInfoMapper, BookHisInfo> implements BookHisInfoService {

    @Autowired
    private BookHisInfoMapper bookHisInfoMapper;

    @Override
    public BookHisInfoVO selectList(BookHisInfoDTO bookHisInfoDTO) {
        IPage<BookHisInfo> page = new Page<>(bookHisInfoDTO.getCurrentPage(), bookHisInfoDTO.getCurrentSize());
        LambdaQueryWrapper<BookHisInfo> bookHisInfoLambdaQueryWrapper = SelectFactory.SelectFactory(bookHisInfoDTO);
        IPage<BookHisInfo> bookHisInfoIPage = bookHisInfoMapper.selectPage(page, bookHisInfoLambdaQueryWrapper);
        return BookHisInfoVO.builder()
                .total(bookHisInfoMapper.selectCount(null))
                .currentPage(bookHisInfoIPage.getRecords())
                .build();
    }
}
