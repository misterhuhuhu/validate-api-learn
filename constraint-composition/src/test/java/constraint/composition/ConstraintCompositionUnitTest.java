package constraint.composition;

import jakarta.validation.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ContextConfiguration(classes = { ConstraintCompositionConfig.class }, loader = AnnotationConfigContextLoader.class)
public class ConstraintCompositionUnitTest {

    @Autowired
    private AccountService accountService;

    private static   Validator validator;

    @BeforeAll
    public  static void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void when_username无效_则_validationShouldReturnTwoViolations() {
        Account account = new Account();
        account.setNickname("valid_nickname123");
        account.setPassword("valid_password123");
        account.setUsername("john");

        Set<ConstraintViolation<Account>> violations = validator.validate(account);

        assertThat(violations).hasSize(2);
        violations.forEach(v-> System.err.println(v.getPropertyPath()+":"+v.getMessage()));
    }

    @Test
    public void whenPasswordIsInvalid_validationShouldReturnSingleViolation() {
        Account account = new Account();
        account.setUsername("valid_username123");
        account.setNickname("valid_nickname123");
        account.setPassword("john");

        Set<ConstraintViolation<Account>> violations = validator.validate(account);

        assertThat(violations).hasSize(1);
        violations.forEach(v-> System.err.println(v.getPropertyPath()+":"+v.getMessage()));
    }

    @Test
    public void whenNicknameIsTooShortButContainsNumericCharacter_validationShouldPass() {
        Account account = new Account();
        account.setUsername("valid_username123");
        account.setPassword("valid_password123");
        account.setNickname("doe1");

        Set<ConstraintViolation<Account>> violations = validator.validate(account);

        assertThat(violations).isEmpty();
        violations.forEach(v-> System.err.println(v.getMessage()));
    }

    @Test
    public void whenMethodReturnValuesIsInvalid_validationShouldFail() {
        Assertions.assertThrows(ConstraintViolationException.class,() -> accountService.getAnInvalidAlphanumericValue());
    }

}