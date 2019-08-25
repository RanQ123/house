package com.team.house.potal.controller;

import com.team.house.entity.District;
import com.team.house.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller(value = "districtController2")
@RequestMapping("/page")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @RequestMapping("/getAllDistrict")
    @ResponseBody
    public List<District> getAllType() {

        return districtService.getAllDistrict();
    }

}

