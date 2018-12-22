package com.zm.springboot.web;/*
 *@author: minz.
 *@create on: 2018/7/19
 */

import com.zm.springboot.dao.categoryDao;
import com.zm.springboot.mapper.birdMapper;
import com.zm.springboot.pojo.bird;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class birdController {

    @Autowired
    private birdMapper bm;

    @ResponseBody
    @RequestMapping("/get")
    public List getbird(){
        List<bird> list = bm.findAll();
        return list;
    }
}
