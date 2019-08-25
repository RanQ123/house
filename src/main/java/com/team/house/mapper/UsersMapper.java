package com.team.house.mapper;

import com.team.house.entity.Users;
import com.team.house.entity.UsersExample;
import java.util.List;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExample(UsersExample example);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    //判断用户是否存在  通过用户名统计个数
    int getUserCount(String name);

}