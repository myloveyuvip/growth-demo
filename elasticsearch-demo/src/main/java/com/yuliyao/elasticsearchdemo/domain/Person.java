package com.yuliyao.elasticsearchdemo.domain;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author yuliyao
 * @date 2019/9/22
 */
@Data
@Document(indexName = "test_index",type = "doc")
public class Person {

    private Long id;

    private String name;

    private Integer age;

    private String sex;

}
