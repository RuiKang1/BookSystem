package cn.lanqiao.booksystem.controller;

import cn.lanqiao.booksystem.mapper.BooksInfoMapper;
import cn.lanqiao.booksystem.modle.dto.BookBorrowDTO;
import cn.lanqiao.booksystem.modle.pojo.BooksInfo;
import cn.lanqiao.booksystem.service.BooksInfoService;
import cn.lanqiao.booksystem.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BorrowInfoController {
    @Autowired
    private BooksInfoService booksInfoService;


    @RequestMapping("book_his/page")
    @ResponseBody
    public ResponseUtils selectUserBorrow(){
        List<BookBorrowDTO> borrowinfo = booksInfoService.selectUserBorrow();
        if(borrowinfo != null){
            return new ResponseUtils(1,"借阅书籍查找成功",borrowinfo);
        }else{
            return new ResponseUtils(0,"借阅书籍查找失败");
        }
    }
    @RequestMapping("book_his/borrow")
    @ResponseBody
    public ResponseUtils borrow(@RequestBody BooksInfo booksInfo){
        int result = booksInfoService.borrow(booksInfo.getBid());
        if (result==1){
            return new ResponseUtils(1,"借阅成功");
        }else {
            return new ResponseUtils(0,"借阅失败");
        }
    }
    @RequestMapping("book_his")
    @ResponseBody
    public ResponseUtils returnBook(Long bid){
        int result = booksInfoService.returnBook(bid);
        if (result==1){
            return new ResponseUtils(1,"还书成功");
        }else {
            return new ResponseUtils(0,"还书失败");
        }
    }

}
