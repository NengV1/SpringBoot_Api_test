package com.ss.springbootgo.springboot_test.entity;


import lombok.Data;

import javax.persistence.*;

@Data
//@IdClass(OrderId.class)
@Entity(name="orders")
public class Order {

    private int qty;

    @AttributeOverrides(value = {
            @AttributeOverride(name = "id", column = @Column(name="o_id")),
            @AttributeOverride(name = "productId", column = @Column(name="p_id"))
    })

    @EmbeddedId
    private OrderId orderId;

}
