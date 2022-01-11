package com.example.elastictest;

import com.example.elastictest.document.TestDocument;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.LinkedHashMap;

@SpringBootApplication
public class ElasticTestApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ElasticTestApplication.class, args);

        ElasticsearchOperations operations = context.getBean(ElasticsearchOperations.class);

        IndexOperations indexOperations = operations.indexOps(TestDocument.class);

        if (!indexOperations.exists()) {
            indexOperations.create();
        }

        Document mapping = indexOperations.createMapping(TestDocument.class);

        ((LinkedHashMap) mapping.get("properties")).remove("fieldTwo");

        indexOperations.putMapping(mapping);

        mapping = indexOperations.createMapping(TestDocument.class);

        indexOperations.putMapping(mapping);

    }

}
