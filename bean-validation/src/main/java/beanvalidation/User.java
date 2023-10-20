package beanvalidation;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class User {

    @NotNull(message = "名字不能为空")
    private String name;

    @AssertTrue
    private boolean working;

    @Size(min = 10, max = 200, message = "字符数应在 10 到 200 之间（含 10 和 200）")
    private String aboutMe;

    @Min(value = 18, message = "年龄不得低于18岁")
    @Max(value = 150, message = "年龄不应超过150岁")
    private int age;

    @Email(message = "电子邮件应有效")
    private String email;

    private List<@NotBlank String> preferences;

    private LocalDate dateOfBirth;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<@Past LocalDate> getDateOfBirth() {
        return Optional.ofNullable(dateOfBirth);
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<String> preferences) {
        this.preferences = preferences;
    }
}
