package enums.constraints.type;


import enums.constraints.CustomerEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class CustomerTypeSubSetValidator implements ConstraintValidator<EnumTypePattern, CustomerEnum> {
    private CustomerEnum[] subset;

    @Override
    public void initialize(EnumTypePattern enumTypePattern) {
       this.subset = enumTypePattern.anyOf();
    }

    @Override
    public boolean isValid(CustomerEnum value, ConstraintValidatorContext context) {
        if(value==null){
            return false;
        }
        return  Arrays.asList(subset)
            .contains(value);
    }
}
