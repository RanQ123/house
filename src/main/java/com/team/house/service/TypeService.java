package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Type;
import com.team.house.util.Page;

import java.util.List;

public interface TypeService {

     //查询所有区域
    public PageInfo<Type> getAllType(Page page);

    //添加区域 ORM
    public int addType(Type Type);

    //查询单条记录
    public Type getType(Integer id);

    //实现修改的业务
    public int updateType(Type Type);

    //实现删除的业务
    public int deleteType(Integer id);

    //实现批量删除的业务
    public int delMoreType(Integer[] ids);

    //查询所有类型
    public List<Type> getAllType();
}
