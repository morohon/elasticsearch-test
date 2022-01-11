package com.example.elastictest.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "test", createIndex = false)
public class TestDocument {

    @Id
    public String id;

    @Field(name = "fieldOne", type = FieldType.Keyword)
    public String fieldOne;

    @Field(name = "fieldTwo", type = FieldType.Keyword)
    public String fieldTwo;

}
