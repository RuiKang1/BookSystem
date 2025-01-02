package cn.lanqiao.booksystem.controller;

import cn.lanqiao.booksystem.modle.pojo.BookTypeInfo;
import cn.lanqiao.booksystem.modle.pojo.BooksInfo;
import cn.lanqiao.booksystem.service.BookService;
import cn.lanqiao.booksystem.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    /**
     * 获取书籍分类信息
     * @return
     */
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

    /**
     * 查找书籍
     * @param name
     * @return
     */
    @RequestMapping("book_info/page")
    @ResponseBody
    public ResponseUtils selectBooksByName(String name,String author,String type,String card){
        List<BooksInfo> booksInfos = null;
        booksInfos = bookService.selectBooksByName(name);
        if(author != null){
            booksInfos = bookService.selectBooksByAuthor(author);
        }else if(type != null){
            booksInfos = bookService.selectBooksByType(type);
        }else if(card != null){
            booksInfos = bookService.selectBooksByCard(card);
        }

//        System.out.println("name:" + name);
//        System.out.println("author:" + author);
//        System.out.println("type:" + type);
//        System.out.println("card:" + card);

        if(booksInfos != null){
            return new ResponseUtils(1,"书籍查找成功",booksInfos);
        }else{
            return new ResponseUtils(0,"书籍查找失败");
        }
    }

//    /**
//     * 根据作者名查找
//     * @param author
//     * @return
//     */
//    @RequestMapping("book_info/page")
//    @ResponseBody
//    public ResponseUtils selectBooksByAuthor(String author){
//        List<BooksInfo> booksInfos = bookService.selectBooksByAuthor(author);
//        if(booksInfos != null){
//            return new ResponseUtils(1,"书籍查找成功",booksInfos);
//        }else{
//            return new ResponseUtils(0,"书籍查找失败");
//        }
//    }
//
//    /**
//     * 根据类型查找
//     * @param type
//     * @return
//     */
//    @RequestMapping("book_info/page")
//    @ResponseBody
//    public ResponseUtils selectBooksByType(String type){
//        List<BooksInfo> booksInfos = bookService.selectBooksByName(type);
//        if(booksInfos != null){
//            return new ResponseUtils(1,"书籍查找成功",booksInfos);
//        }else{
//            return new ResponseUtils(0,"书籍查找失败");
//        }
//    }
//
//    /**
//     * 根据书号查找
//     * @param card
//     * @return
//     */
//    @RequestMapping("book_info/page")
//    @ResponseBody
//    public ResponseUtils selectBooksByCard(String card){
//        List<BooksInfo> booksInfos = bookService.selectBooksByName(card);
//        if(booksInfos != null){
//            return new ResponseUtils(1,"书籍查找成功",booksInfos);
//        }else{
//            return new ResponseUtils(0,"书籍查找失败");
//        }
//    }

    /**
     * 添加书籍
     * @param book
     * @return
     */
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
