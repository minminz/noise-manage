package com.zm.springboot.redisTest;/*
 *@author: minz.
 *@create on: 2018/7/19
 */

import com.zm.springboot.dao.category;
import com.zm.springboot.dao.categoryDao;
import com.zm.springboot.pojo.bird;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RedisTest {

//    @Autowired
//    @Qualifier("userRedisTemplate")
//    private RedisTemplate<String,bird> rts;

//    @Autowired
//    @Qualifier("redisTemplate")
//    RedisTemplate template;

    @Autowired
    @Qualifier("redisTemplate")
    RedisTemplate templateoo;

    @Autowired
    categoryDao categorydao;

//   /*解决乱码的问题*/
//    private RedisTemplate redisTemplate;
//    @Autowired(required = false)
//    public void setRedisTemplate(RedisTemplate redisTemplate) {
//        RedisSerializer stringSerializer = new StringRedisSerializer();
//        redisTemplate.setKeySerializer(stringSerializer);
//        redisTemplate.setValueSerializer(stringSerializer);
//        redisTemplate.setHashKeySerializer(stringSerializer);
//        redisTemplate.setHashValueSerializer(stringSerializer);
//        this.redisTemplate = redisTemplate;
//    }

    @ResponseBody
    @RequestMapping("/redis")
    public String rediss(){
//        for (int i = 0;i < 5; i++){
//            b.setId(i+1);
//            b.setName("我是鸟儿"+i);
//            rts.opsForList().rightPush("birds",b);
//        }

        templateoo.opsForValue().set("z","abc111");
        String s=(String)templateoo.opsForValue().get("z");
        return s;
    }


//    /*先从redis中查询，没有就从mysql查找，查找后再存入redis*/
    @ResponseBody
    @RequestMapping("/getsql")
    public List getcc(){
        List<category> c = new ArrayList<>();//category必须可序列化
        try {
            c = (List<category>)templateoo.opsForList().range("list",0,-1);
            if (c.size()!=0){
                System.out.println("从reids中获取到!!!!!!");
                return c;
            }
        }catch (Exception e){

        }
        c = categorydao.findAll();
        try {
            templateoo.opsForList().leftPushAll("list",c);
        }catch (Exception e){

        }
        System.out.println("redis中没有，存入.............. ");
        return c;

    }
}
