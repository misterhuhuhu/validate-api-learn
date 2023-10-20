package constraint.composition;

public class Account {

    @ValidNumberAndLength
    private String username;

    @ValidNumberAndLengthWithSingleViolation
    private String password;

    @ValidLengthOrNumericCharacter
    private String nickname;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
