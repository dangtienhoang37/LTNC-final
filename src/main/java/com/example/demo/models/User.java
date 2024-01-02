package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "nguoi_dung")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

//    @ManyToOne
//    @JoinColumn(name = "role_id", nullable = false)

    @Column(name = "role_id",nullable = false)
    private  Integer role;

    public User() {

    }

    public User(long id, String username, String password, Integer role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
