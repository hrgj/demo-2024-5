package com.example.demo.es;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;

@Data
public class BookIndexRes {
    private Integer id;
    private Integer bookId;
    private String title;
    private String author;
    private BigDecimal price;
}
