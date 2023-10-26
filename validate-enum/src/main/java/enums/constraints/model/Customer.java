package enums.constraints.model;

import enums.constraints.CustomerEnum;
import enums.constraints.pattern.EnumPattern;

public class Customer {
    
    private String customerEnumString;
    
    @EnumPattern(regexp = "NEW|DEFAULT")
    private CustomerEnum customerEnum;
    
    
    public Customer(String customerEnumString, CustomerEnum customerEnum) {
        this.customerEnumString = customerEnumString;
        this.customerEnum = customerEnum;
    }
    
    public static class Builder {
        private String customerEnumString;
        private CustomerEnum customerEnum = CustomerEnum.NEW;
        
        public Builder withCustomerTypeString(String customerEnumString) {
            this.customerEnumString = customerEnumString;
            return this;
        }
        public Builder withCustomerTypeMatchesPattern(CustomerEnum customerEnum) {
            this.customerEnum = customerEnum;
            return this;
        }
        public Customer build() {
            return new Customer(customerEnumString, customerEnum );
        }
    }
}
