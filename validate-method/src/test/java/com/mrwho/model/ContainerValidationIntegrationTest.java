package com.mrwho.model;


import jakarta.annotation.Resource;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;


@ContextConfiguration
@SpringBootTest(classes = {ValidateDemoApplication.class})
public class ContainerValidationIntegrationTest {
    
    @Resource
    CustomerWithMethod customerWithMethod;
    
    @Test
    public void 当非法输入函数参数_则ConstraintViolationException异常() {
        Assertions.assertThrows(ConstraintViolationException.class, () -> customerWithMethod.createReservation(LocalDate.now(), 0, null));
    }
    
    @Test
    public void 当正常输入函数参数_则无异常() {
        Assertions.assertDoesNotThrow(() -> customerWithMethod.createReservation(LocalDate.now()
                                                                                         .plusDays(1), 2, new CustomerWithMethod.Customer()));
    }
    
    @Test
    public void 当正常构造对象_则无异常() {
        CustomerWithConstructor customerWithConstructor = new CustomerWithConstructor("Doe", "John");
        Assertions.assertDoesNotThrow(() -> customerWithMethod.createReservation(customerWithConstructor));
    }
    
    @Test
    public void 当非法构造对象_则ConstraintViolationException异常() {
        CustomerWithoutConstructor customer = new CustomerWithoutConstructor();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        Assertions.assertThrows(ConstraintViolationException.class, () -> customerWithMethod.createReservation(customer));
    }
    
    @Test
    public void 当返回值非法_则ConstraintViolationException异常() {
        
        Assertions.assertThrows(ConstraintViolationException.class, () -> customerWithMethod.getAllCustomers());
    }
}
