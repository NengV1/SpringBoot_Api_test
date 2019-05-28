package com.ss.springbootgo.springboot_test.entity;


import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;


@Data
@Embeddable
public class OrderId implements Serializable {

    public OrderId(){}

    private long id;
    private long productId;


}
