package enums.constraints;


import enums.constraints.string.model.Customer;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class EnumStringValidatorUnitTest {
    
    private static Validator validator;
    
    @BeforeAll
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }
    
    @Test
    public void whenAllInvalid_thenViolationsShouldBeReported() {
        Customer customer = new Customer();
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertThat(violations.size()).isEqualTo(1);
    }
    @Test
    public void whenAllValid_thenViolationsShouldBeReported() {
        Customer customer = new Customer("DEFAULT");
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertThat(violations.size()).isEqualTo(0);
    }
    
   
}