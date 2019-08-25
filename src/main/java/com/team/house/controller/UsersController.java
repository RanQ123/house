package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Users;
import com.team.house.service.UsersService;
import com.team.house.util.UserCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("/getRUser")
    @ResponseBody
    public Map<String,Object> getRUser(UserCondition userCondition){

        PageInfo<Users> pageInfo = usersService.getAllRUsers(userCondition);
        //返回结果
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
}
