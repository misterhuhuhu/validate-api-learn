package enums.constraints.type.model;

import enums.constraints.CustomerEnum;
import enums.constraints.type.EnumTypePattern;

public class Customer {
    
    @EnumTypePattern(anyOf = { CustomerEnum.NEW, CustomerEnum.OLD })
    private CustomerEnum customerEnum;
    
    public Customer(CustomerEnum customerEnum) {
        this.customerEnum = customerEnum;
    }
    
    public static class Builder {
        private CustomerEnum customerEnum = CustomerEnum.NEW;
        public Builder withCustomerTypeMatchesPattern(CustomerEnum customerEnum) {
            this.customerEnum = customerEnum;
            return this;
        }
        public Customer build() {
            return new Customer(customerEnum );
        }
    }
}
