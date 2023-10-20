package beanvalidation.application.entities;


import jakarta.validation.constraints.NotBlank;

public class User {
    @NotBlank(message = "Name必填")
    private String name;
    
    @NotBlank(message = "Email必填")
    private String email;
    
    public User(){}
    
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" + ", name=" + name + ", email=" + email + '}';
    }    
}
