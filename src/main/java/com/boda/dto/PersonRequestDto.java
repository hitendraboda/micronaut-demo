package com.boda.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Introspected
@Serdeable
public class PersonRequestDto {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Positive
    private int age;
}
