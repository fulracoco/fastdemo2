package com.example.fastdemo.cachedao;

import java.util.List;

public interface ICacheDao<T> {
	
	public void saveOrUpdate(Object key,T t);
	
	public void delete(Object key);
	
	public T get(Object key);
	
	public void saveWithExpireMs(Object key,T t,Long expireTime);
	
	public void saveWithExpireMi(Object key,T t,Long expireTime);
	
	public void saveOrUpdateList(List<T> ts);
	
}
