package com.yuliyao.elasticsearchdemo.service;

import com.yuliyao.elasticsearchdemo.domain.Person;

import java.util.List;

/**
 * @author yuliyao
 * @date 2019/9/22
 */
public interface PersonService {

    List<Person> queryAll();

    List<Person> queryByName(String name);

    void add(Person person);
}
