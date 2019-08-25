package com.team.house.mapper;

import com.team.house.entity.House;
import com.team.house.entity.HouseExample;
import com.team.house.util.HouseCondition;

import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    //查询用户发布的出租房
    public List<House> getHouseByUser(Integer userid);

    //查询出租房信息
    public House getHouseById(String id);

    /**
     * 查询出租房的状态信息
     * 审核状态为0  表示为未审核
     * 审核状态为1  表示为已审核
     * @param ispass
     * @return
     */
    public List<House> getHouseByIsPass(Integer ispass);

    /**
     * 浏览出租房信息
     * @param condition  查询条件
     * @return  所有出租房
     */
    public List<House> getHouseBySearch(HouseCondition condition);


}