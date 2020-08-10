package com.revature.model;

import javax.persistence.*;

@Entity
@Table

@NamedNativeQueries(
        value = {
                @NamedNativeQuery(
                        name = "saveUser",
                        query = "insert into app_user()"
                )
        }

)
public class User {
    @Id
    @Column(name="user_id", columnDefinition="serial primary key")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="first_name", columnDefinition = "not null")
    private String firstName;
    @Column(name="last_name", columnDefinition = "not null")
    private String lastName;
    @Column(name="username", columnDefinition = "unique not null")
    private String username;
    @Column(name="password", columnDefinition = "not null")
    private String password;
    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="user_role", referencedColumnName="role_id", columnDefinition = "int")
    private Role role;

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}