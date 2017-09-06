package com.example.fastdemo.cachedao.persondao.impl;

import org.springframework.stereotype.Repository;

import com.example.fastdemo.bean.Person;
import com.example.fastdemo.cachedao.impl.CacheDaoImpl;
import com.example.fastdemo.cachedao.persondao.IPersonCache;

import javax.annotation.Resource;
import java.util.List;

@Repository(value = "personCache")
public class PersonCacheImpl extends CacheDaoImpl<Person> implements IPersonCache {

    @Resource(name = "cacheDao")
    private CacheDaoImpl cacheDao;

    @Override
    public void saveOrUpdate(String id, Person p) {
        cacheDao.saveOrUpdate(id, p);
    }

    @Override
    public void delete(String id) {

        cacheDao.delete(id);

    }

    @Override
    public Person find(String id) {

        return (Person) cacheDao.get(id);

    }

    @Override
    public void saveOrUpdatePersonList(List<Person> ps) {

        ps.forEach(p -> cacheDao.saveOrUpdate(p.getId(), p));

    }
}
