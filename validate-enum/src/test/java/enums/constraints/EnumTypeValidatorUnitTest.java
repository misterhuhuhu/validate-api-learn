package enums.constraints;


import enums.constraints.type.model.Customer;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class EnumTypeValidatorUnitTest {
    
    private static Validator validator;
    
    @BeforeAll
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }
    
    @Test
    public void whenAllInvalid_thenViolationsShouldBeReported() {
        Customer customer = new Customer(CustomerEnum.DEFAULT);
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertThat(violations.size()).isEqualTo(1);
    }
    
    @Test
    public void whenNullInvalid_thenViolationsShouldBeReported() {
        Customer customer = new Customer(null);
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertThat(violations.size()).isEqualTo(1);
    }
    
}