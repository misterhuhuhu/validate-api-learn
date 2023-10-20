package com.mrwho.model;

import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

/**
 * 实体类 无构造
 */
@Validated
@Data
public class CustomerWithoutConstructor {
    @Size(min = 5, max = 200)
    private String firstName;

    @Size(min = 5, max = 200)
    private String lastName;
}
