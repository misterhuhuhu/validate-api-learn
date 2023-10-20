package com.mrwho;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;



public class CustomerValidValidator implements ConstraintValidator<CustomerValid, Customer> {

    @Override
    public boolean isValid(Customer customer, ConstraintValidatorContext context) {

        if (customer == null) {
            return true;
        }

        if (!(customer instanceof Customer)) {
            throw new IllegalArgumentException("Illegal method signature, expected parameter of type Reservation.");
        }

        if (customer.getFirstName() == null || customer.getLastName() == null ) {
            return false;
        }

        return (customer.getLastName()
                        .length()>5
            && customer.getFirstName().length()>10);
    }
}
