package com.ss.springbootgo.springboot_test.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.Arrays;

@Log4j2
@Configuration
@EnableCaching
@RequiredArgsConstructor
public class ProductCacheConf {

    @Bean
    public SimpleCacheManager buildSimpleCacheManager() {
        CaffeineCache productCache = buildCaffeineCache(CacheName.PRODUCT, 100);
        CaffeineCache productsCache = buildCaffeineCache(CacheName.PRODUCTS, 10);
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        simpleCacheManager.setCaches(Arrays.asList(productCache, productsCache));
        simpleCacheManager.initializeCaches();
        return simpleCacheManager;
    }

    private CaffeineCache buildCaffeineCache(String name, long maxSize) {
        log.info(() -> "Build CaffeineCache[" + name + "] , maximumSize[" + maxSize + "]");
        return new CaffeineCache(name, Caffeine.newBuilder()
                .softValues()
                .maximumSize(maxSize)
                .expireAfterAccess(Duration.ofHours(1))
                .expireAfterWrite(Duration.ofHours(24))
                .build());
    }

    @Caching(evict = {
            @CacheEvict(cacheNames = CacheName.PRODUCTS, allEntries = true),
            @CacheEvict(cacheNames = CacheName.PRODUCT, allEntries = true)
    })
    public void evictAll() {
    }

    public static class CacheName {
        public static final String PRODUCT = "PRODUCT";
        public static final String PRODUCTS = "PRODUCTS";
    }


}
