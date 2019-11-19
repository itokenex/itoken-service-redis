package com.funtl.itoken.service.redis.service;

/**
 *
 */
public interface RedisService {

    public void put(String key,String value,long seconds);

    public String get(String key);
}
