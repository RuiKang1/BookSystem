package cn.lanqiao.booksystem.controller;

import cn.lanqiao.booksystem.modle.pojo.BookTypeInfo;
import cn.lanqiao.booksystem.modle.pojo.BooksInfo;
import cn.lanqiao.booksystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/book/book_categories")
    @ResponseBody
    public List<BookTypeInfo> getBookType(){
        List<BookTypeInfo> bookType = bookService.getBookType();
        if(bookType != null){
            return bookType;
        }else{
            return null;
        }
    }

    @RequestMapping("book_info/page")
    @ResponseBody
    public List<BooksInfo> selectBooks(){
        List<BooksInfo> booksInfos = bookService.selectBooks();
        if(booksInfos != null){
            return booksInfos;
        }else{
            return null;
        }
    }


}
