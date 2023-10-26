package com.mrwho.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidationTest {
    private static Validator validator;
    
    @BeforeAll
    public static void beforeClass() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validatorFactory.close();
        validator = validatorFactory.getValidator();
    }
    
    @Test
    public void 当_指定名字长度小于最小值_则_验证失败() {
        Person person = new Person();
        person.setName("John Doe");
        person.setAge(18);
        
        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        assertEquals(1, violations.size());
        
        ConstraintViolation<Person> violation = violations.iterator().next();
        //返回插值
        violations.forEach(v -> System.err.println(v.getMessage()));
        assertEquals("Name should be between 10 and 100 characters", violation.getMessage());
    }
    
    @Test
    public void 当_指定年龄小于最小值_则_验证失败() {
        Person person = new Person();
        person.setName("John Stephaner Doe");
        person.setAge(16);
        
        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        assertEquals(1, violations.size());
        
        ConstraintViolation<Person> violation = violations.iterator().next();
        assertEquals("Age should not be less than 18", violation.getMessage());
    }
}
