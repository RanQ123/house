package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.Type;
import com.team.house.entity.TypeExample;
import com.team.house.mapper.TypeMapper;
import com.team.house.mapper.StreetMapper;
import com.team.house.service.TypeService;
import com.team.house.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private StreetMapper streetMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)  //挂起事务,不其于事务执行
    public PageInfo<Type> getAllType(Page page) {
        //1.开启分页
        PageHelper.startPage(page.getPage(),page.getRows());
        //2.查询所有
        //封装条件的实体类
        TypeExample TypeExample = new TypeExample();
        List<Type> list = typeMapper.selectByExample(TypeExample);
        //3.获取分页相关的属性
        PageInfo<Type> pageInfo = new PageInfo<>(list);
        return pageInfo;

    }

    @Override
    public int addType(Type Type) {
        return typeMapper.insertSelective(Type);
    }

    @Override
    public Type getType(Integer id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateType(Type Type) {
        return typeMapper.updateByPrimaryKeySelective(Type);
    }

    @Override
    @Transactional
    //在业务方法上添加事务支持的同时，在实现业务代码时添加了try..catch异步捕获会导致事务失效.
    public int deleteType(Integer id) {
        //判断该类型下有没有房屋，如果则删除失败，不与删除，否则删除
        // select count(1) from house where type=id
        return  typeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int delMoreType(Integer[] ids) {
        return typeMapper.delMoreType(ids);
    }

    @Override
    public List<Type> getAllType() {
        return typeMapper.selectByExample(new TypeExample());
    }
}
