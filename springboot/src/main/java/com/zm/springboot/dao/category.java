package com.zm.springboot.dao;/*
 *@author: minz.
 *@create on: 2018/7/19
 * @Entity 注解表示这是个实体类
@Table(name = "category") 表示这个类对应的表名是 category
@Id 表明主键
@GeneratedValue(strategy = GenerationType.IDENTITY) 表明自增长方式
@Column(name = "id") 表明对应的数据库字段名
 */

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "category")
public class category implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
