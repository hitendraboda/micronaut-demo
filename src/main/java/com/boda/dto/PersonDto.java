package com.boda.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

@Data
@Introspected
@Serdeable
public class PersonDto {
    private long id;
    private String firstName;
    private String lastName;
    private int age;
}
