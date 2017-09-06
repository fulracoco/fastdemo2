package com.example.fastdemo.service.impl;

import javax.annotation.Resource;

import com.example.fastdemo.databseDao.mapper.PersonMapperDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.fastdemo.bean.Person;
import com.example.fastdemo.cachedao.persondao.IPersonCache;
import com.example.fastdemo.service.IPersonService;

import java.util.ArrayList;
import java.util.List;

@Service(value="personService")
public class PersonServiceImpl implements IPersonService{

	@Resource(name="personCache")
	private IPersonCache personCache;

	@Resource(name="personMapperDao")
	private PersonMapperDao personMapperDao;

	@Override
	public void save(Person p) {

		personCache.saveOrUpdate(p.getId(),p);
		
	}

	@Override
	public Person find(Person p) {

		Person person = personCache.get(p.getId());
		return person;

	}

	@Override
	public void savePerson(Person person){

	}

	@Override
	public Person getPerson(Person p){
		return null;
	}

	@Override
	public List<Person> getPlist(String name, Integer age){
       List<Person> plist = new ArrayList<Person>();

       return plist;
	}

    @Override
    public List<Person> queryPerson2(Person person){
		return personMapperDao.select(person);
	}
}
