package com.example.fastdemo.service;

import com.example.fastdemo.bean.Person;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IPersonService {
	
	public void save(Person p);
	
	public Person find(Person p);

	public void savePerson(Person person);

	public Person getPerson(Person p);

	public List<Person> getPlist(String name, Integer age);

	public List<Person> queryPerson2(Person person);
}
