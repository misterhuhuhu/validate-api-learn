package beanvalidation.nullannotation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @org.springframework.lang.NonNull
    private String fullName;
    @org.springframework.lang.Nullable
    private String nickName;
    public String nullGetFullName(){
        return nickName;
    }
}
