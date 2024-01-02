package com.example.demo.models;

public class UserDTO {
    private long id;
    private String username;
    private String password;

    private  int role;

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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public UserDTO(long id, String username, String password, int role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
