package com.gerasimchuk.samplefilter.custom_once_per_request_filter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/resource")
    public String resource(){
        return "resource: ok";
    }
}
