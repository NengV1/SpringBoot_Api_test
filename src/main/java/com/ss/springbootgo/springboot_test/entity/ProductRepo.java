package com.ss.springbootgo.springboot_test.entity;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ProductRepo extends JpaRepository<Product, Long> {
}
