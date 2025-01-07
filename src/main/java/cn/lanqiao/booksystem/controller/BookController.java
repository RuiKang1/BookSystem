package cn.lanqiao.booksystem.controller;

import cn.lanqiao.booksystem.modle.pojo.BookTypeInfo;
import cn.lanqiao.booksystem.modle.pojo.BooksInfo;
import cn.lanqiao.booksystem.service.BookService;
import cn.lanqiao.booksystem.utils.ResponseUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
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
    @RequestMapping("/book_info/page")
    @ResponseBody
    public ResponseUtils selectBooksByName(String name,String author,String type,String card,Integer page,Integer pageSize){
        List<BooksInfo> booksInfos = null;
        booksInfos = bookService.selectBooksByName(name,page,pageSize);
        if(author != null){
            booksInfos = bookService.selectBooksByAuthor(author,page,pageSize);
        }else if(type != null){
            booksInfos = bookService.selectBooksByType(type,page,pageSize);
        }else if(card != null){
            booksInfos = bookService.selectBooksByCard(card,page,pageSize);
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


    /**
     * 添加书籍
     * @param book
     * @return
     */
    @RequestMapping("/addBook")
    @ResponseBody
    public ResponseUtils addBook(@RequestBody BooksInfo book){
        int result = bookService.addBook(book);
        if(result > 0){
            return new ResponseUtils(1,"书籍添加成功");
        }else{
            return new ResponseUtils(0,"书籍添加失败");
        }
    }


    /**
     * 修改书籍
     * @param book
     * @return
     */
    @PutMapping("/bookList")
    @ResponseBody
    public ResponseUtils editBookInfo(@RequestBody BooksInfo book){
        int result = bookService.editBookInfo(book);
        if(result > 0){
            return new ResponseUtils(1,"书籍修改成功");
        }else{
            return new ResponseUtils(0,"书籍修改失败");
        }
    }

    /**
     * 删除书籍
     * @param bids
     * @return
     */
    @DeleteMapping("/bookList")
    @ResponseBody
    public ResponseUtils deleteBook(String bids){
        String[] bidsStrArr = bids.split(",");
        List<Integer> bidsList = new ArrayList<>();

        for(String bid : bidsStrArr){
            bidsList.add(Integer.parseInt((bid)));
        }
//        System.out.println("bidsStrArr:" + Arrays.toString(bidsStrArr));
//        System.out.println("bids:" + bids);
//        System.out.println("bidsList" + bidsList);

        try {
            int result = bookService.deleteBooks(bidsList);
            if(result > 0){
                return new ResponseUtils(1,"批量删除成功");
            }else{
                return new ResponseUtils(0,"批量删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils(0,"批量删除失败");
        }

    }


}
