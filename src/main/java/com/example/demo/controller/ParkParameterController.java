package com.example.demo.controller;


import com.example.demo.entity.ParkParameter;
import com.example.demo.service.IParkParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author JFREE
 * @since 2018-11-06
 */
@Controller
@RequestMapping("/parkParameter")
public class ParkParameterController {

    @Autowired
    private IParkParameterService parkParameterService;

    @GetMapping("test")
    public ParkParameter get() {
        return parkParameterService.getById(1);
    }

}
