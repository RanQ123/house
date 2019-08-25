package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.service.DistrictService;
import com.team.house.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")  //表示后所有的控制器请求都在/admin目录下
public class DistrictController {

    @Autowired
    private DistrictService districtService;


    //分页查询所有
    @RequestMapping("/getDistrict") //dagagrid会自动传page页码,rows页大小
    @ResponseBody
    public Map<String,Object> getDistrict(Page page){
        PageInfo<District> pageInfo = districtService.getAllDistrict(page);
        //返回total建，rows的页数据
        Map<String,Object> map = new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    //实现添加
    @RequestMapping("/addDistrict")
    @ResponseBody
    public String addDistrict(District district){
        int temp=-1;
        try{
            //调用业务实现添加
            temp=districtService.addDistrict(district);
            //传统实现:跳转到视图
            //返回数据
        }catch (Exception e){
            e.printStackTrace(); //都会选择记录日志
        }
        return "{\"result\":"+temp+"}";

        /*public String getDistrict(District district){
            //调用业务
            int temp=districtService.addDistrict(district);
            return "{\"result\":"+temp+"}";*/
        }

    //通过主键查询单条
    @RequestMapping("/getOneDistrict")
    @ResponseBody
    public District getDistrict(Integer id){
        return districtService.getDistrict(id);
    }

    //实现修改
    @RequestMapping("/upDistrict")
    @ResponseBody
    public String upDistrict(District district){
        //调用业务
        int temp = districtService.updateDistrict(district);
        return "{\"result\":"+temp+"}";
    }

    //实现删除
    @RequestMapping("/deleteDistrict")
    @ResponseBody
    public String deleteDistrict(Integer id){
        //调用业务
        try{
            districtService.deleteDistrict(id);
            return "{\"result\":1}";
        }catch (Exception e) {
            //记录错误信息
            System.out.println("出错啦！");
        }
        return "{\"result\":0}";
    }


    //批量删除区域
    //delMoreDistrict?id=1&id=2&id=3  = public String delDistrict(Integer []id)
    @RequestMapping("/delMoreDistrict")  //1,2,3
    @ResponseBody
    public String delDistrict(String ids){
        //将字符串转化为数组
        String arys[]=ids.split(",");
        Integer [] is=new Integer[arys.length];
        for (int i=0;i<arys.length;i++){
            is[i]=new Integer(arys[i]);
        }
        //调用业务
        int temp=this.districtService.delMoreDistrict(is);
        return "{\"result\":"+temp+"}";
    }

}
