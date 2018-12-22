package com.zm.springboot.controller;/*
 *@author: minz.
 *@create on: 2018/7/19
 * 错误显示页
 */


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Model defaultErrorHandler(HttpServletRequest req, Exception e,Model mav) throws Exception {
        mav.addAttribute(e);
        return mav;
    }
}
