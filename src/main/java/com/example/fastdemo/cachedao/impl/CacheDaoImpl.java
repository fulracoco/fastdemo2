package com.example.fastdemo.cachedao.impl;


import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import com.example.fastdemo.cachedao.ICacheDao;

@Repository(value = "cacheDao")
public class CacheDaoImpl<T> implements ICacheDao<T> {



    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Resource(name = "redisTemplate")
    private ValueOperations<Object, Object> valOps;

    @Override
    public void saveOrUpdate(Object key, T t) {
        valOps.set(key, t);
    }

    @Override
    public void delete(Object key) {

        valOps.set(key, null);

    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(Object key) {

        return (T) valOps.get(key);
    }

    @Override
    public void saveWithExpireMs(Object key, T t, Long expireTime) {

        valOps.set(key, t, expireTime, TimeUnit.MILLISECONDS);
    }

    @Override
    public void saveWithExpireMi(Object key, T t, Long expireTime) {

        valOps.set(key, t, expireTime, TimeUnit.MINUTES);

    }

    @Override
    public void saveOrUpdateList(List<T> ts) {
        // TODO Auto-generated method stub

    }

}
