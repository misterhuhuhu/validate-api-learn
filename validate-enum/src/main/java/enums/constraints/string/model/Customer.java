package enums.constraints.string.model;

import enums.constraints.CustomerEnum;
import enums.constraints.string.ValueOfEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    
    @ValueOfEnum(enumClass = CustomerEnum.class)
    private String customerTypeString;
    
}
