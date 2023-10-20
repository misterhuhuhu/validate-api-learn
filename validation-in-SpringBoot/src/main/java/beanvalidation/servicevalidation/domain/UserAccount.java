package beanvalidation.servicevalidation.domain;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UserAccount {
    
    @NotBlank(message = "Name必填")
    private String name;
    
    @NotBlank(message = "Email必填")
    private String email;
    
}
