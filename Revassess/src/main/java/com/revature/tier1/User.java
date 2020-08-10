package com.revature.tier1;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String role;

    public User(){}

    public User(int i, String f, String l, String u, String p, String r){
        id = i;
        firstName = f;
        lastName = l;
        username = u;
        password = p;
        role = r;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
