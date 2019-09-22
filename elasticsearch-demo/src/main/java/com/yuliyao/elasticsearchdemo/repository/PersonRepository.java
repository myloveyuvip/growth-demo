package com.yuliyao.elasticsearchdemo.repository;

import com.yuliyao.elasticsearchdemo.domain.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import java.util.List;

/**
 * @author yuliyao
 * @date 2019/9/22
 */
public interface PersonRepository extends ElasticsearchCrudRepository<Person, Long> {

    List<Person> findByName(String name);

}
