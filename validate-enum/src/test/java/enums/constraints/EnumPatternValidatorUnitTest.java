package enums.constraints;


import enums.constraints.model.Customer;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnumPatternValidatorUnitTest {
    
    private static Validator validator;
    
    @BeforeAll
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }
    
    @Test
    public void whenEnumMatchesRegex_thenShouldNotReportConstraintViolations() {
        Customer customer = new Customer.Builder().withCustomerTypeMatchesPattern(CustomerEnum.DEFAULT).build();
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertTrue(violations.isEmpty());
    }
    
    @Test
    public void whenEnumNull_thenShouldNotReportConstraintViolations() {
        Customer customer = new Customer.Builder().withCustomerTypeMatchesPattern(null)
                                    .build();
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        Assertions.assertEquals(violations.size(), 1);
        violations.forEach(v -> System.err.println(v.getMessage()));
    }
    
    @Test
    public void whenEnumDoesNotMatchRegex_thenShouldGiveOccurrenceOfConstraintViolations() {
        Customer customer = new Customer.Builder().withCustomerTypeMatchesPattern(CustomerEnum.OLD)
                                    .build();
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        Assertions.assertEquals(violations.size(), 1);
        violations.forEach(v -> System.err.println(v.getMessage()));
    }
    
}