package com.baizhi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class TestController {


    @RequestMapping("test1")
  //  @ResponseBody
    public String test1(){

        return "index";
    }

}
