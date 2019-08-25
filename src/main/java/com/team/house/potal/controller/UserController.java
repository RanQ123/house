package com.team.house.potal.controller;

import com.team.house.entity.Users;
import com.team.house.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/page")
public class UserController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("/reg")
    public String reg(Users users){
        int temp = usersService.regsUser(users);
        if (temp>0)
            return "login"; //登录页
        else
            return "regs";  //注册页
    }

    //检查用户名是否存在 异步（返回数据）
    @RequestMapping("/checkUserName")
    @ResponseBody
    public Map<String,Object> checkUserName(String username){
        int temp = usersService.isUserNameExists(username);
        //返回数据
        Map<String,Object> map = new HashMap<>();
        map.put("result",temp);
        return map;
    }

    //登入
    @RequestMapping("/login")
    public String checkUserName(String username, String password, HttpSession session){
        Users user = usersService.login(username, password);
        if (user==null)
            return "login";
        else
            //注意:只要登入，必需使用session保存登入人的信息或者cookie保存
            //session保存的信息在服务器与浏览共存
            session.setAttribute("userInfo",user);
            //设置保存的时间
            session.setMaxInactiveInterval(600);  //秒
            return "redirect:getHouse";
    }
}
