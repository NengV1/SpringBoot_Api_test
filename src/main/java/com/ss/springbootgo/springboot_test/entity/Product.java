package com.ss.springbootgo.springboot_test.entity;



import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Immutable
@Entity(name="products")
@SequenceGenerator(name="products_seq")
@Table(indexes = {@Index(name = "products_idx_code_unique", columnList = "code", unique = true)})
public class Product {

        @Id
        @GeneratedValue(generator = "products_seq")
        private Long id;
        private String name;
        private String code;
        private String detail;
        private LocalDateTime createdDate;
        private LocalDateTime updatedDate;



}
