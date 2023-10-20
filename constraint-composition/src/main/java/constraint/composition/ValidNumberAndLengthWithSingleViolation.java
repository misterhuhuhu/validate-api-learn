package constraint.composition;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@NotNull
@Pattern(regexp = ".*\\d.*", message = "必须有一个数字")
@Length(min = 6, max = 32, message = "字数在6到32之间")
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {})
@ReportAsSingleViolation
public @interface ValidNumberAndLengthWithSingleViolation {

    String message() default "field should have a valid length and contain numeric character(s).";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}