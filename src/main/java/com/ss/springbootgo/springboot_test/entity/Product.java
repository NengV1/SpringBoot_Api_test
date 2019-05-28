package com.ss.springbootgo.springboot_test.entity;



import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "products")
@EqualsAndHashCode(callSuper = false)
@SequenceGenerator(name = "products_seq")
@Table(indexes = {
        @Index(name = "products_idx_code_unique", columnList = "code", unique = true),
        @Index(name = "products_idx_status", columnList = "status")
})
public class Product extends Common {

    @Id
    @GeneratedValue(generator = "products_seq")
    private long id;
    private String code;
    private String name;
    private String detail;
    private Double score;
 //   private Double price;

    @Column(length = 1)
    private Status status;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "alias_name", length = 50)
    private Set<String> aliasNames = new HashSet<>();

    @RequiredArgsConstructor
    public enum Status {
        APPROVED("A"),
        NOT_APPROVED("N"),
        DELETED("D"),
        PENDING("P");

        @Getter
        private final String code;

        public static Product.Status toStatus(String code) {
            return Stream.of(Product.Status.values()).parallel()
                    .filter(status -> status.getCode().equalsIgnoreCase(code))
                    .findAny().orElseThrow(() -> new IllegalArgumentException("The code : " + code + " is illegal argument."));

        }
    }
}

