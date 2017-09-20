package com.example.fastdemo.controller;

import javax.annotation.Resource;

import com.example.fastdemo.constants.ReturnCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.fastdemo.bean.Person;
import com.example.fastdemo.service.IPersonService;

import java.util.List;

//@RestController
@Controller
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
    public ResponseEntity<?> search(String id) {
        Person person = new Person();
        ReturnCode returnCode = new ReturnCode();

        person.setId(id);
        Person person2 = personService.find(person);
        if (person2 == null) {
            System.out.println("123456");
            returnCode.setErrorCode("11111111");
            returnCode.setErrorMsg("not found");
            return new ResponseEntity<ReturnCode>(returnCode,HttpStatus.OK);
        }
        return new  ResponseEntity<Person>(person2,HttpStatus.OK);


    }

    @ResponseBody
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
