package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.service.HouseService;
import com.team.house.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class HouseController {

    @Autowired
    private HouseService houseService;

    //查询未审核出租房信息
    @RequestMapping("/getNoPassHouse")
    @ResponseBody
    public Map<String,Object> getNoPassHouse(Page page){
        PageInfo<House> pageInfo = houseService.getHouseByIsPass(page, 0);//0表示为审核
        //封装返回的数据
        Map<String,Object> map = new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());

        return map;
    }

    //查询通过审核出租房信息
    @RequestMapping("/getYesPassHouse")
    @ResponseBody
    public Map<String,Object> getYesPassHouse(Page page){
        PageInfo<House> pageInfo = houseService.getHouseByIsPass(page, 1);//0表示为审核
        //封装返回的数据
        Map<String,Object> map = new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());

        return map;
    }

    //审核的状态；通过审核
    @RequestMapping("/goYesPassHouse")
    @ResponseBody
    public Map<String,Object> goYesPassHouse(String id){
        int temp = houseService.PassHouse(id, 1);//1表示通过审核
        //封装返回的数据
        Map<String,Object> map = new HashMap<>();
        map.put("result",temp);

        return map;
    }

    //审核的状态；取消审核
    @RequestMapping("/goNoPassHouse")
    @ResponseBody
    public Map<String,Object> goNoPassHouse(String id){
        int temp = houseService.PassHouse(id, 0);//0表示未通过审核
        //封装返回的数据
        Map<String,Object> map = new HashMap<>();
        map.put("result",temp);

        return map;
    }
}
