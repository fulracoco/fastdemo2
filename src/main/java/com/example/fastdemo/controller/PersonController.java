package com.example.fastdemo.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.fastdemo.bean.Person;
import com.example.fastdemo.service.IPersonService;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Resource(name = "personService")
    private IPersonService personService;

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    @RequestMapping(value = "register")
    public String register(String id, String name, Integer age) {

        Person person = new Person(id, name, age);
        personService.save(person);
        return id;

    }

    @RequestMapping(value = "search")//,method= RequestMethod.POST)
    public String search(String id) {
        Person person = new Person();
        person.setId(id);
        Person person2 = personService.find(person);
        if (person2 != null) {
            return person2.toString();
        }
        return "NOT FOUND";

    }

    @RequestMapping(value = "search/{myid}")//,method= RequestMethod.POST)
    public String search2(@PathVariable("myid") String id) {
        Person person = new Person();
        person.setId(id);
        List<Person> person2 = personService.queryPerson2(person);
        if (person2 != null) {
            return person2.toString();
        }
        return "NOT FOUND";

    }
}
