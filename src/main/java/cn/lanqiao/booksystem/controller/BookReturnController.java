package cn.lanqiao.booksystem.controller;

import cn.lanqiao.booksystem.common.Result;
import cn.lanqiao.booksystem.modle.dto.BookHisInfoDTO;
import cn.lanqiao.booksystem.modle.vo.BookHisInfoVO;
import cn.lanqiao.booksystem.service.BookHisInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/BookReturn")
@CrossOrigin
public class BookReturnController {
    @Autowired
    private BookHisInfoService bookHisInfoService;
    @RequestMapping("/return")
    public Result updateReturn(@RequestBody BookHisInfoDTO bookHisInfoDTO) {
        System.err.println(bookHisInfoDTO);
        BookHisInfoVO list  = bookHisInfoService.selectList(bookHisInfoDTO);
        return Result.ok(list);
    }

    @GetMapping("delete")
    public Result deleteReturn(@RequestParam Integer id) {
        bookHisInfoService.removeById(id);
        return Result.ok();
    }

}
