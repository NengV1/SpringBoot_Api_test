package com.ss.springbootgo.springboot_test.component.converter;


import com.ss.springbootgo.springboot_test.entity.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class ProductStatusConverter implements Converter<String, Product.Status> {

    @Override
    public Product.Status convert(String code) {
        return Product.Status.toStatus(code);
    }
}
