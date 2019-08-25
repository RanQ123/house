package com.team.house;

import com.team.house.service.DistrictService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext");
        DistrictService districtService = (DistrictService)cxt.getBean("DistrictServiceImpl");
        districtService.deleteDistrict(1017);
    }
}
