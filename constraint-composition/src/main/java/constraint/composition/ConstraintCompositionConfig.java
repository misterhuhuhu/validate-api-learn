package constraint.composition;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@Configuration
public class ConstraintCompositionConfig {

    @Bean
    public DefaultListableBeanFactory methodValidationPostProcessor(DefaultListableBeanFactory defaultListableBeanFactory) {
        //PostProcessor需要使用注册到BeanFactory,不能直接 注册为Bean
        defaultListableBeanFactory.addBeanPostProcessor(new MethodValidationPostProcessor());
        return defaultListableBeanFactory;
    }

    @Bean
    public AccountService accountService() {
        return new AccountService();
    }
    
}