package com.zm.springboot.mapper;/*
 *@author: minz.
 *@create on: 2018/7/19
 */

import com.zm.springboot.pojo.bird;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface birdMapper {

    List<bird> findAll();
}
