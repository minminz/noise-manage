package com.zm.springboot.dao;/*
 *@author: minz.
 *@create on: 2018/7/19
 * 继承了JpaRepository，
 * 并且提供泛型<Category,Integer> 表示这个是针对Category类的DAO,Integer表示主键是Integer类型。
 * JpaRepository 这个父接口，就提供了CRUD, 分页等等一系列的查询了，直接拿来用，
 * 都不需要二次开发的了。
 */

import org.springframework.data.jpa.repository.JpaRepository;

public interface categoryDao extends JpaRepository<category,Integer>{
}
