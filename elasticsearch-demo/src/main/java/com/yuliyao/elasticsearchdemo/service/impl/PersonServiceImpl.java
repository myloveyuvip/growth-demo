package com.yuliyao.elasticsearchdemo.service.impl;

import com.google.common.collect.Lists;
import com.yuliyao.elasticsearchdemo.domain.Person;
import com.yuliyao.elasticsearchdemo.repository.PersonRepository;
import com.yuliyao.elasticsearchdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuliyao
 * @date 2019/9/22
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Person> queryAll() {
        Iterable<Person> all = personRepository.findAll();
        return Lists.newArrayList(all);
    }

    @Override
    public List<Person> queryByName(String name) {
        return personRepository.findByName(name);
    }

    @Override
    public void add(Person person) {
        personRepository.save(person);
    }

}
