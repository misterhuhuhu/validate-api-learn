package constraint.composition;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
@AllArgsConstructor
public class AccountService {

    @NumberAndLengthReturnValue
    public String getAnInvalidAlphanumericValue() {
        return "john";
    }
}
