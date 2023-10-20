package com.mrwho;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.executable.ExecutableValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.Set;


public class ManualValidationTest {
    private static ExecutableValidator executableValidator;
    
    @BeforeAll
    public static void beforeClass() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        executableValidator = validatorFactory.getValidator().forExecutables();
        /**
         * ExecutableValidator 提供了四种方法：
         *
         * validateParameters()和validateReturnValue()用于方法验证
         * validateConstructorParameters()和validateConstructorReturnValue()用于构造函数验证
         *
         * 不鼓励直接从应用程序代码中调用此接口
         */
    }
    @Test
    public void 当_校验无效构造函数返回值_则_错误校验数量() throws NoSuchMethodException {
        
        Constructor<Customer> constructor = Customer.class.getConstructor(String.class, String.class);
        Customer createdObject = new Customer("William", "Smith");
//        Set<ConstraintViolation<Customer>> violations = executableValidator.validateConstructorReturnValue(constructor, createdObject);
        Set<ConstraintViolation<Customer>> constraintViolations = executableValidator.validateConstructorReturnValue(constructor, createdObject);
        constraintViolations.forEach(System.out::println);
        
    }
}
