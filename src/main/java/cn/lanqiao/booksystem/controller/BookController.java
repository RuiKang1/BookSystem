package cn.lanqiao.booksystem.controller;

import cn.lanqiao.booksystem.modle.pojo.BookTypeInfo;
import cn.lanqiao.booksystem.modle.pojo.BooksInfo;
import cn.lanqiao.booksystem.service.BookService;
import cn.lanqiao.booksystem.utils.ResponseUtils;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/book/book_categories")
    @ResponseBody
    public ResponseUtils getBookType(){
        List<BookTypeInfo> bookType = bookService.getBookType();
        if(bookType != null){
            return new ResponseUtils(1,"书籍的分类列表查询成功",bookType);
        }else{
            return new ResponseUtils(0,"书籍的分类列表查询失败");
        }
    }

    @RequestMapping("book_info/page")
    @ResponseBody
    public ResponseUtils selectBooks(){
        List<BooksInfo> booksInfos = bookService.selectBooks();
        if(booksInfos != null){
            return new ResponseUtils(1,"书籍查找成功",booksInfos);
        }else{
            return new ResponseUtils(0,"书籍查找失败");
        }
    }

    @RequestMapping("addBook")
    @ResponseBody
    public ResponseUtils addBook(@RequestBody BooksInfo book){
        int result = bookService.addBook(book);
        if(result > 0){
            return new ResponseUtils(1,"书籍添加成功");
        }else{
            return new ResponseUtils(0,"书籍添加失败");
        }
    }



}
