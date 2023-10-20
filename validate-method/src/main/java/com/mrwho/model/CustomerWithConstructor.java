package com.mrwho.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

/**
 * 实体类  有构造函数
 */
@Validated
@Data
public class CustomerWithConstructor {
    private String firstName;
    
    private String lastName;
    
    /**
     * validate 构造函数
     *
     * @param firstName
     * @param lastName
     */
    public CustomerWithConstructor(@Size(min = 5, max = 200) @NotNull String firstName, @Size(min = 5, max = 200) @NotNull String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    
}
