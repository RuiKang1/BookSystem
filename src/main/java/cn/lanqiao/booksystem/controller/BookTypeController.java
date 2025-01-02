package cn.lanqiao.booksystem.controller;

import cn.lanqiao.booksystem.modle.pojo.BookTypeInfo;
import cn.lanqiao.booksystem.service.BookTypeService;
import cn.lanqiao.booksystem.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//@Controller
@RestController
@RequestMapping("type")
public class BookTypeController {

    @Autowired
    private BookTypeService bookTypeService;


    /**
     * 查询（分页）
     * @return
     */
    @RequestMapping("/selectPage")
    @ResponseBody
    public ResponseUtils selectPage(){
        try {
            List<BookTypeInfo> bookTypeInfos = bookTypeService.selectTypeAll();
            if (bookTypeInfos != null){
                return new ResponseUtils<>(1,"查询成功",bookTypeInfos);
            }else {
                return new ResponseUtils<>(2,"查询失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);

        }
    }

    /**
     * 新增分类（提交并关闭）
     * @return
     */
    @RequestMapping("/CommitClosed")
    @ResponseBody
    public ResponseUtils CommitClosed(@RequestBody BookTypeInfo bookTypeInfo){
        try {
            int result = bookTypeService.insertType(bookTypeInfo);
            if (result == 1){
                //新增成功
                return new ResponseUtils(1,"新增成功");
            }else {
                //新增失败
                return new ResponseUtils<>(2,"新增失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    /**
     * 新增分类（提交不关闭）
     * @return
     */
    @RequestMapping("/Commit")
    @ResponseBody
    public ResponseUtils Commit(@RequestBody BookTypeInfo bookTypeInfo){
        try {
            int result = bookTypeService.insertType(bookTypeInfo);
            if (result == 1){
                //新增成功
                return new ResponseUtils(1,"新增成功");
            }else {
                //新增失败
                return new ResponseUtils<>(2,"新增失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除功能
     * @param bookTypeInfo
     * @return
     */
    @RequestMapping("/delType")
    @ResponseBody
    public ResponseUtils del(@RequestBody BookTypeInfo bookTypeInfo){
        try {
            int del = bookTypeService.delType(bookTypeInfo.getTid());
            if (del == 1){
                //删除成功
                return new ResponseUtils(1,"删除成功");
            }else {
                //删除失败
                return new ResponseUtils(2,"删除成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
