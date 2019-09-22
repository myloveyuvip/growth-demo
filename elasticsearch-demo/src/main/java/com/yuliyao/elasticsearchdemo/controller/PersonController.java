package com.yuliyao.elasticsearchdemo.controller;

import com.yuliyao.elasticsearchdemo.domain.Person;
import com.yuliyao.elasticsearchdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yuliyao
 * @date 2019/9/22
 */
@RestController
@RequestMapping("person")
public class PersonController {


    @Autowired
    PersonService personService;

    @GetMapping("queryAll")
    public List<Person> queryAll() {
        return personService.queryAll();
    }

    @PostMapping("add")
    public void add(@RequestBody Person person) {
        personService.add(person);
    }

    @GetMapping("query")
    public List<Person> query(String name) {
        return personService.queryByName(name);
    }

}
