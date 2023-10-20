package com.mrwho.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.List;

@Validated
@Component
public class CustomerWithMethod {
    public void createReservation(@NotNull @Future LocalDate begin, @Min(1) int duration, @NotNull Customer customer) {
    }
    
    /**
     * 只有构造函数校验无效
     * @param customer
     */
    public void createReservation(@Valid  CustomerWithConstructor customer) {
    }
    @NotNull
    @Size(min = 1)
    public List<@NotNull Customer> getAllCustomers(){
        return null;
    }
    /**
     *
     * @param customer 必须加上@Valid
     */
    public void createReservation(@Valid CustomerWithoutConstructor customer) {
    }
    public static class Customer{
    
    }
}
