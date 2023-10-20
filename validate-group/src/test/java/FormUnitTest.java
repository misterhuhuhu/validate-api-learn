import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import javaxval.validationgroup.AdvanceInfo;
import javaxval.validationgroup.BasicInfo;
import javaxval.validationgroup.CompleteInfo;
import javaxval.validationgroup.Form;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class FormUnitTest {
    
    private static Validator validator;
    
    private Form buildFormWithBasicInfo() {
        Form form = new Form();
        form.setFirstName("devender");
        form.setLastName("kumar");
        form.setCaptcha("Y2HAhU5T");
        form.setPhone("12345");
        return form;
    }
    @BeforeAll
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory()
                            .getValidator();
    }
    
    @Test
    void 当所有正常() {
        Form form = buildFormWithBasicInfo();
        Set<ConstraintViolation<Form>> violations = validator.validate(form, AdvanceInfo.class);
        assertThat(violations.size()).isEqualTo(0);
    }
    
    @Test
    void 当_FirstName为空_使用AdvanceInfoGroup_则没有Invalid() {
        Form form = buildFormWithBasicInfo();
        form.setFirstName("");
        Set<ConstraintViolation<Form>> violations = validator.validate(form, AdvanceInfo.class);
        assertThat(violations.size()).isEqualTo(0);
    }
    @Test
    void 当_FirstName为空_使用BasicInfoGroup_则出现一个Invalid() {
        Form form = buildFormWithBasicInfo();
        form.setFirstName("");
        Set<ConstraintViolation<Form>> violations = validator.validate(form, BasicInfo.class);
        assertThat(violations.size()).isEqualTo(1);
    }
    @Test
    void 当_phone为空_使用CompleteInfoGroup_则出现一个Invalid() {
        Form form = buildFormWithBasicInfo();
        form.setFirstName("");
        Set<ConstraintViolation<Form>> violations = validator.validate(form, CompleteInfo.class);
        assertThat(violations.size()).isEqualTo(1);
    }
    @Test
    void 当_captcha为空_使用CompleteInfoGroup_则出现一个Invalid() {
        Form form = buildFormWithBasicInfo();
        form.setCaptcha("");
        Set<ConstraintViolation<Form>> violations = validator.validate(form, CompleteInfo.class);
        assertThat(violations.size()).isEqualTo(1);
    }
   
}
