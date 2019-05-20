package com.ss.springbootgo.springboot_test.entity;



import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Product {


        @Id
        @GeneratedValue
        private Long id;
        private String name;
        private String code;



}
