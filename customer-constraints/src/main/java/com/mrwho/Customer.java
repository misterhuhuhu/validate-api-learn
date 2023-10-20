package com.mrwho;

import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

/**
 * 实体类 无构造
 */
@Data
public class Customer {
    private String firstName;
    private String lastName;
    
    @CustomerValid
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
