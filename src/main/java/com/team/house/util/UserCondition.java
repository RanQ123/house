package com.team.house.util;

//用户条件查询实体
public class UserCondition extends Page {

    private  String name;
    private  String telephone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


}
