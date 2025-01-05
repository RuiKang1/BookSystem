package cn.lanqiao.booksystem.controller;

import cn.lanqiao.booksystem.modle.pojo.BookTypeInfo;
import cn.lanqiao.booksystem.modle.pojo.BooksInfo;
import cn.lanqiao.booksystem.service.BookService;
import cn.lanqiao.booksystem.service.BooksInfoService;
import cn.lanqiao.booksystem.service.BorrowingService;
import cn.lanqiao.booksystem.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BorrowingController {
//    @Autowired
//    private BorrowingService borrowingService;
//
//    /**
//     * 获取书籍分类信息
//     * @return
//     */
//    @RequestMapping("/book/book_categories")
//    @ResponseBody
//    public ResponseUtils getBookType(){
//        List<BookTypeInfo> bookType = borrowingService.getBookType();
//        if(bookType != null){
//            return new ResponseUtils(1,"书籍的分类列表查询成功",bookType);
//        }else{
//            return new ResponseUtils(0,"书籍的分类列表查询失败");
//        }
//    }
//
//    /**
//     * 查找书籍
//     * @param name
//     * @return
//     */
//    @RequestMapping("/book_info/page")
//    @ResponseBody
//    public ResponseUtils selectBooksByName(String name,String author,String type,String card){
//        List<BooksInfo> booksInfos = null;
//        booksInfos = borrowingService.selectBooksByName(name);
//        if(author != null){
//            booksInfos = borrowingService.selectBooksByAuthor(author);
//        }else if(type != null){
//            booksInfos = borrowingService.selectBooksByType(type);
//        }else if(card != null){
//            booksInfos = borrowingService.selectBooksByCard(card);
//        }
////        System.out.println("name:" + name);
////        System.out.println("author:" + author);
////        System.out.println("type:" + type);
////        System.out.println("card:" + card);
//
//        if(booksInfos != null){
//            return new ResponseUtils(1,"书籍查找成功",booksInfos);
//        }else{
//            return new ResponseUtils(0,"书籍查找失败");
//        }
//    }
}
