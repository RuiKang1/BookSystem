package cn.lanqiao.booksystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookController {
    @RequestMapping("/book/book_categories")
    @ResponseBody
    public List<String> getBookType(){

        return null;
    }
}
