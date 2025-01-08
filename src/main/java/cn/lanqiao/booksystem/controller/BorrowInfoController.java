package cn.lanqiao.booksystem.controller;

import cn.lanqiao.booksystem.modle.dto.BookBorrowDTO;
import cn.lanqiao.booksystem.modle.pojo.BookHisInfo;
import cn.lanqiao.booksystem.modle.pojo.BooksInfo;
import cn.lanqiao.booksystem.service.BookService;
import cn.lanqiao.booksystem.service.BooksInfoService;
import cn.lanqiao.booksystem.utils.ResponseUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class BorrowInfoController {
    @Autowired
    private BooksInfoService booksInfoService;
    @Autowired
    private BookService bookService;

    @RequestMapping("book_his/page")
    @ResponseBody
    public ResponseUtils selectUserBorrow(HttpServletRequest request,String name,String card,Integer page,Integer pageSize){
        List<BookHisInfo> bookHisInfos = null;
        bookHisInfos = booksInfoService.selectBooksByName(name,page,pageSize);
        if (card!=null){
            bookHisInfos = booksInfoService.selectBooksByCard(card,page,pageSize);
        }
        HttpSession session = request.getSession();
        Long aid = (Long) session.getAttribute("aid");
        System.out.println(aid);
        if(bookHisInfos != null){
            return new ResponseUtils(1,"借阅书籍查找成功",bookHisInfos);
        }else{
            return new ResponseUtils(0,"借阅书籍查找失败");
        }
    }
    @RequestMapping("book_his/borrow")
    @ResponseBody
    public ResponseUtils borrow(HttpServletRequest request, @RequestBody BookHisInfo bookHisInfo) {
        HttpSession session = request.getSession();
        Long aid = (Long) session.getAttribute("aid");
        int result = booksInfoService.borrow(aid,bookHisInfo);
        int result1 = booksInfoService.changeStatus(bookHisInfo.getBid());
        System.out.println(bookHisInfo);


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
        booksInfoService.deleteInfo(bid);
        if (result==1){
            return new ResponseUtils(1,"还书成功");
        }else {
            return new ResponseUtils(0,"还书失败");
        }
    }



}
