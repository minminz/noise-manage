package com.zm.springboot.controller;/*
 *@author: minz.
 *@create on: 2018/7/19
 */

import com.zm.springboot.dao.categoryDao;
import com.zm.springboot.dao.category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class categoryController {

    @Autowired
    categoryDao cd;

    @ResponseBody
    @RequestMapping("getcategory")
    public List getcategory(){
        List<category> list = cd.findAll();
        return list;
    }

    @RequestMapping("insert")
    public String insert() {
        category cg = new category();
        cg.setName("oo");
        cd.save(cg);
        return "ok";
    }
}
