package com.zm.springboot.web;/*
 *@author: minz.
 *@create on: 2018/7/8
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    @RequestMapping("aa")
    public String hello(){
        return "listCategory";
    }

}
