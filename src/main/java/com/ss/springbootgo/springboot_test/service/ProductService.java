package com.ss.springbootgo.springboot_test.service;

import com.ss.springbootgo.springboot_test.entity.Product;
import com.ss.springbootgo.springboot_test.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import java.util.List;


import static com.ss.springbootgo.springboot_test.config.CacheConf.CacheName.PRODUCT;
import static com.ss.springbootgo.springboot_test.config.CacheConf.CacheName.PRODUCTS;


    @Log4j2
    @Service
    @RequiredArgsConstructor
    @CacheConfig(cacheNames = PRODUCT)

    public class ProductService extends  CommonService {

    private final ProductRepository repo;

    @Cacheable(cacheNames = PRODUCTS)
    public List<Product> findAll(Product.Status status) {
        log.info("Find all {}", status);
        return (StringUtils.isEmpty(status)) ? repo.findAll() : repo.findAllByStatus(status);
    }


    @Cacheable(unless = "#result?.score < 50")
    public Product find(long id) {
        log.info("Find id[{}]", id);
        return repo.findById(id).orElseThrow(() -> new RuntimeException("data not found"));
    }

    @CachePut(key = "#product.id")
    @CacheEvict(cacheNames = PRODUCTS, allEntries = true)
    public Product save(Product product) {
        log.info("Save");
        return repo.saveAndFlush(product);
    }

    @CachePut(key = "#product.id")
    @CacheEvict(cacheNames = PRODUCTS, allEntries = true)
    public Product replace(Product product) {
        log.info("Replace");
        find(product.getId());
        return repo.saveAndFlush(product);
    }


    @Transactional
    @Caching(evict = {
            @CacheEvict(cacheNames = PRODUCTS, allEntries = true),
            @CacheEvict(cacheNames = PRODUCT, key = "#id")
    })
    public int updateScore(long id, double score) {
        log.info("UpdateScore id[{}], score[{}]", id, score);
        return repo.updateScore(id, score);
    }

    @Caching(evict = {
            @CacheEvict(cacheNames = PRODUCTS, allEntries = true),
            @CacheEvict(cacheNames = PRODUCT, key = "#id")
    })

    public void delete(Long id) {
        log.info("Delete id[{}]", id);
        repo.deleteById(id);
    }




}
