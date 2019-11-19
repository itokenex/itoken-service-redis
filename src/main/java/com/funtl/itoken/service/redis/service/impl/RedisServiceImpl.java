package com.funtl.itoken.service.redis.service.impl;

import com.funtl.itoken.service.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService{

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void put(String key, String value, long seconds) {
        System.out.println("执行put方法...");
        redisTemplate.opsForValue().set(key,value,seconds, TimeUnit.SECONDS);
    }

    @Override
    public String get(String key) {
        Object o = redisTemplate.opsForValue().get(key);
        if(o!=null) {
            return o.toString();
        }else{
            return null;
        }
    }
}
