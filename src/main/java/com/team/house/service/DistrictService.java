package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.util.Page;

import java.util.List;

public interface DistrictService {

     //查询所有区域
    public PageInfo<District> getAllDistrict(Page page);

    //添加区域 ORM
    public int addDistrict(District district);

    //查询单条记录
    public District getDistrict(Integer id);

    //实现修改的业务
    public int updateDistrict(District district);

    //实现删除的业务
    public int deleteDistrict(Integer id);

    //实现批量删除的业务
    public int delMoreDistrict(Integer[] ids);

    //查询所有区域
    public List<District> getAllDistrict();
}
