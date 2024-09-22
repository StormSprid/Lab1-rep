package com.example.demo;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotEmpty;

public class User {
//    @NotEmpty
    private String name;
    private String email;

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
}
