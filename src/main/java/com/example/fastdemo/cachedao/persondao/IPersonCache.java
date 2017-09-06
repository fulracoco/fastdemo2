package com.example.fastdemo.cachedao.persondao;

import java.util.List;

import com.example.fastdemo.bean.Person;
import com.example.fastdemo.cachedao.ICacheDao;

public interface IPersonCache extends  ICacheDao<Person>{

	public void saveOrUpdate(String id,Person p);
	
	public void delete(String id);
	
	public Person find(String id);
	
	public  void saveOrUpdatePersonList(List<Person> ps);
		
}
