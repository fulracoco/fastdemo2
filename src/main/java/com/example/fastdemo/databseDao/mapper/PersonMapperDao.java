package com.example.fastdemo.databseDao.mapper;

import com.example.fastdemo.bean.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value="personMapperDao")
public interface PersonMapperDao {

    public List<Person> select(Person p);

}
