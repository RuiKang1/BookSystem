package cn.lanqiao.booksystem.controller;

import cn.lanqiao.booksystem.common.Result;
import cn.lanqiao.booksystem.modle.dto.BookHisInfoDTO;
import cn.lanqiao.booksystem.modle.pojo.BookHisInfo;
import cn.lanqiao.booksystem.modle.pojo.BookReturnPojo;
import cn.lanqiao.booksystem.modle.vo.BookHisInfoVO;
import cn.lanqiao.booksystem.service.BookHisInfoService;
import cn.lanqiao.booksystem.service.BookReturnService;
import cn.lanqiao.booksystem.utils.ResponseUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

//@RestController
//@RequestMapping("/BookReturn")
//@CrossOrigin
@Controller
public class BookReturnController {
    @Autowired
    private BookReturnService bookReturnService;

//    @Autowired
//    private BookHisInfoService bookHisInfoService;
//    @RequestMapping("/return")
//    public Result updateReturn(@RequestBody BookHisInfoDTO bookHisInfoDTO) {
//        System.err.println(bookHisInfoDTO);
//        BookHisInfoVO list  = bookHisInfoService.selectList(bookHisInfoDTO);
//        return Result.ok(list);
//    }
//
//    @GetMapping("delete")
//    public Result deleteReturn(@RequestParam Integer id) {
//        bookHisInfoService.removeById(id);
//        return Result.ok();
//    }
    @RequestMapping("/BookReturn/return")
    @ResponseBody
    public ResponseUtils list(@RequestBody BookReturnPojo bookReturnPojo){
        List<BookHisInfo> bookHisInfoList = null;
        String type = bookReturnPojo.getNumber();

        if(type == "" || bookReturnPojo.getQueryCriteria() == ""){
            bookHisInfoList = bookReturnService.selectData(bookReturnPojo);
        }

        if(type.equals("1")){
            bookHisInfoList = bookReturnService.selectDataByBookName(bookReturnPojo);
        }else if(type.equals("2")){
            bookHisInfoList = bookReturnService.selectDataByUsername(bookReturnPojo);
        }else if(type.equals("3")){
            bookHisInfoList = bookReturnService.selectDataByCard(bookReturnPojo);
        }

        if(bookHisInfoList != null){
            return new ResponseUtils(1,"查询成功",bookHisInfoList);
        }else{
            return new ResponseUtils(0,"查询失败");
        }

    }

    @RequestMapping("BookReturn/delete")
    @ResponseBody
    public ResponseUtils delete(Integer id){
        int result = bookReturnService.delete(id);
        if(result > 0){
            return new ResponseUtils(1,"删除成功");
        }else{
            return new ResponseUtils(0,"删除失败");
        }
    }

}
