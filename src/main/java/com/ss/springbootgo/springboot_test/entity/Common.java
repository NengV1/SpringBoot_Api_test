package com.ss.springbootgo.springboot_test.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.AccessLevel;
import lombok.Setter;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.OffsetDateTime;

@Getter
@Setter(AccessLevel.PROTECTED)
@MappedSuperclass
@EntityListeners(value = Listeners.class)
public abstract class Common {

    private OffsetDateTime createdDate;
    private OffsetDateTime updatedDate;

    @Version
    @JsonIgnore
    private int version;

}

