package beanvalidation.servicevalidation.service;


import beanvalidation.servicevalidation.dao.UserAccountDao;
import beanvalidation.servicevalidation.domain.UserAccount;
import jakarta.annotation.Resource;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class UserAccountService {

    @Resource
    private Validator validator;

    @Resource
    private UserAccountDao dao;

    public String addUserAccount(UserAccount useraccount) {

        Set<ConstraintViolation<UserAccount>> violations = validator.validate(useraccount);

        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<UserAccount> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
            }

            throw new ConstraintViolationException("Error occurred: " + sb, violations);
        }
        
        String result = dao.addUserAccount(useraccount);
        return result + ":Account for " + useraccount + " Added!";
    }

}
