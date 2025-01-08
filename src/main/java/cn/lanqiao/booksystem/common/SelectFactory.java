package cn.lanqiao.booksystem.common;

import cn.lanqiao.booksystem.modle.dto.BookHisInfoDTO;
import cn.lanqiao.booksystem.modle.pojo.BookHisInfo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

public class SelectFactory {

    public static LambdaQueryWrapper<BookHisInfo> SelectFactory(BookHisInfoDTO bookHisInfoDTO) {
        LambdaQueryWrapper<BookHisInfo> wrapper = new LambdaQueryWrapper<>();
        if (bookHisInfoDTO.getNumber() == 0 || bookHisInfoDTO.getQueryCriteria().equals("")) {
            return wrapper;
        }
        if (bookHisInfoDTO.getNumber() == 1) {
            return wrapper.eq( BookHisInfo::getName, bookHisInfoDTO.getQueryCriteria());
        }
        if (bookHisInfoDTO.getNumber() == 2) {
            return wrapper.eq( BookHisInfo::getUsername, bookHisInfoDTO.getQueryCriteria());
        }
        if (bookHisInfoDTO.getNumber() == 3) {
            return wrapper.eq(BookHisInfo::getAdminName, bookHisInfoDTO.getQueryCriteria());
        }
        if (bookHisInfoDTO.getNumber() == 4) {
            return wrapper.eq( BookHisInfo::getCard, bookHisInfoDTO.getQueryCriteria());
        }
        throw new managementException(ResultCodeEnum.APP_LOGIN_USERNAME_IF);
    }
}
