package com.ss.springbootgo.springboot_test.repository;

import com.ss.springbootgo.springboot_test.entity.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


public interface  ProductRepository extends CommonRepository<Product, Long>  {

    List<Product> findAllByStatus(Product.Status status);

    //    @Modifying
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE products SET score = :score WHERE id = :id", nativeQuery = true)
    int updateScore(@Param("id") long id, @Param("score") double score);




}
