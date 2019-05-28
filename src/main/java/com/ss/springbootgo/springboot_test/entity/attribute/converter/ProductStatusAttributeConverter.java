package com.ss.springbootgo.springboot_test.entity.attribute.converter;

import com.ss.springbootgo.springboot_test.entity.Product;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;


@Converter(autoApply = true)
public class ProductStatusAttributeConverter implements AttributeConverter<Product.Status, String> {

    @Override
    public String convertToDatabaseColumn(Product.Status status) {
        return Objects.isNull(status) ? null : status.getCode();
    }

    @Override
    public Product.Status convertToEntityAttribute(String code) {
        return Objects.isNull(code) ? null : Product.Status.toStatus(code);
    }

}
