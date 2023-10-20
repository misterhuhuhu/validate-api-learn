package javaxval.validationgroup;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Form {
    @NotBlank(groups = BasicInfo.class)
    private String firstName;
    @NotBlank(groups = AdvanceInfo.class)
    private String lastName;
    @NotBlank(groups = {BasicInfo.class, AdvanceInfo.class})
    private String captcha;
    @NotBlank(groups = CompleteInfo.class)
    private String phone;
    
}
