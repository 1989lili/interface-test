package com.tuling.xxy.controller;


import com.tuling.xxy.annotation.ReplaceMethod;
import com.tuling.xxy.entity.AgencyTest;
import com.tuling.xxy.service.AgencyTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *  代办控制器
 *
 * @author xiongxy
 * @since 2021-09-11
 */
@RestController
@RequestMapping("/agencyTest")
public class AgencyTestController {

    @Autowired
    AgencyTestService agencyTestService;

    @GetMapping("/list")
    public List<AgencyTest> list(){
        return agencyTestService.getAll();
    }

    @PostMapping("/save")
    public String add(AgencyTest agencyTest){
        agencyTestService.save(agencyTest);
        return "success";
    }

}

