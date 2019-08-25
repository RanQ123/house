package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Users;
import com.team.house.util.UserCondition;

public interface UsersService {

    //查询所有注册用户，分页，条件
    //带条件查询包含查询所有
    public PageInfo<Users> getAllRUsers(UserCondition userCondition);

    //实现用户注册
    public int regsUser(Users users);

    /**
     * 检查用户名是否存在
     * @param name  用户名
     * @return  总行数  如果返回1说明存在，返回0说明不存在
     */
    public int isUserNameExists(String name);

    /**
     *登入功能
     * @param username   用户名称
     * @param password   密码
     * @return  用户对象
     */
    public Users login(String username,String password);
}
