package com.funtl.itoken.service.redis.controller;


import com.funtl.itoken.service.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "put",method = RequestMethod.POST)
    public String put(String key,String value,long seconds){
        System.out.println("key:"+key);
        System.out.println("value:"+value);
        System.out.println("seconds:"+seconds);
        redisService.put(key, value, seconds);
        return "ok";
    }

    @RequestMapping(value = "putData",method = RequestMethod.GET)
    public String putData(String key,String value,long seconds){

        redisService.put(key, value, seconds);
        return "ok";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/getData")
    public String get(String key){

        String o = redisService.get(key);
        if(o!=null){
            System.out.println("---------------->o:"+o.toString());
            return o.toString();
        }else{
            System.out.println("redis为空...");
            return null;
        }

    }
}
