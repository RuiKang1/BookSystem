package cn.lanqiao.booksystem.controller;

import cn.lanqiao.booksystem.modle.pojo.BooksInfo;
import cn.lanqiao.booksystem.modle.pojo.UserInfo;
import cn.lanqiao.booksystem.service.UserMsgService;
import cn.lanqiao.booksystem.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserMsgController {
    @Autowired
    private UserMsgService userMsgService;


    @RequestMapping("/user/page")
    @ResponseBody
    public ResponseUtils selectBooksByName(String username,String name,Integer page, Integer pageSize){
        List<UserInfo> userInfos = null;
        userInfos = userMsgService.selectUserByUsername(username,page,pageSize);
        if(name != null){
            userInfos = userMsgService.selectUserByName(name,page,pageSize);
        }

        if(userInfos != null){
            return new ResponseUtils(1,"用户查找成功",userInfos);
        }else{
            return new ResponseUtils(0,"用户查找失败");
        }
    }

    @RequestMapping("/user/edit")
    @ResponseBody
    public ResponseUtils editBookInfo(@RequestBody UserInfo user){
        int result = userMsgService.editUserInfo(user);
        if(result > 0){
            return new ResponseUtils(1,"书籍修改成功");
        }else{
            return new ResponseUtils(0,"书籍修改失败");
        }
    }
    //sfse
    @DeleteMapping("/user")
    @ResponseBody
    public ResponseUtils deleteUsers(String aids){
        System.out.println(aids);
        String[] aidsStrArr = aids.split(",");
        List<Integer> aidsList = new ArrayList<>();

        for(String bid : aidsStrArr){
            aidsList.add(Integer.parseInt((bid)));
        }

        try {
            int result = userMsgService.deleteUsers(aidsList);
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
