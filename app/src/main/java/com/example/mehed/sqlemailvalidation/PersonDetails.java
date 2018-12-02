package com.example.mehed.sqlemailvalidation;

public class PersonDetails {

    private String name,email,username, password;

    PersonDetails(String name, String email, String password, String username) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }
}
