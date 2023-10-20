package beanvalidation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;


public class ValidationIntegrationTest {
    
    private static Validator validator;
    private static ValidatorFactory factory;
    
    @BeforeAll
    public static void setup() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @AfterAll
    public static void close() {
        if(factory!=null){
            factory.close();
        }
    }
    private User createUser() {
        User user = new User();
        user.setName("John");
        user.setWorking(true);
        user.setAge(18);
        return user;
    }
    
    @Test
    public void 如果名称为空_名称验证失败() {
        User user = new User();
        user.setWorking(true);
        user.setAboutMe("Its all about me!!");
        user.setAge(50);
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        violations.forEach(k-> System.err.println(k.getMessage()));
        Assertions.assertFalse(violations.isEmpty());
    }
    
    @Test
    public void aboutMe不在范围内_aboutMe验证失败() {
        User user = new User();
        user.setName("MyName");
        user.setAboutMe("Its a");
        user.setAge(50);
        user.setWorking(true);
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        violations.forEach(k-> System.err.println(k.getMessage()));
        Assertions.assertFalse(violations.isEmpty());
    }
    
    @Test
    public void 名字为空年龄不在范围内工作为false_validationFailsWithThreeErrors() {
        User user = new User();
        user.setAboutMe("Its all about me!!");
        user.setAge(300);
        
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        Assertions.assertFalse(violations.isEmpty());
        violations.forEach(k-> System.err.println(k.getMessage()));
        Assertions.assertEquals(violations.size(), 3);
    }
    
    @Test
    public void 无效Email_thenValidationFails() {
        User user = createUser();
        user.setEmail("john");
        
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        violations.forEach(k-> System.err.println(k.getMessage()));
        Assertions.assertEquals(1, violations.size());
    }
    
    @Test
    public void 空Preference_thenValidationFails() {
        User user = createUser();
        user.setPreferences(Collections.singletonList(" "));
        
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        violations.forEach(k-> System.err.println(k.getMessage()));
        Assertions.assertEquals(1, violations.size());
    }
    
    @Test
    public void 空Optional_thenValidationSucceeds() {
        User user = createUser();
        
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        violations.forEach(k-> System.err.println(k.getMessage()));
        Assertions.assertEquals(0, violations.size());
    }
    
    @Test
    public void 将来的DateOfBirth_thenValidationFails() {
        User user = createUser();
        user.setDateOfBirth(LocalDate.now().plusDays(1));
        
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        violations.forEach(k-> System.err.println(k.getMessage()));
        Assertions.assertEquals(1, violations.size());
        
    }
}
