package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "sv")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ho_ten")
    private String hoTen;
    @Column(name = "mssv")
    private String mssv;
    @Column(name = "khoa")
    private String khoa;
    @Column(name = "so_the")
    private String soThe;
    @Column(name = "user_id")
    private String userId;

    public Student(Integer id, String hoTen, String mssv, String khoa, String soThe, String userId) {
        this.id = id;
        this.hoTen = hoTen;
        this.mssv = mssv;
        this.khoa = khoa;
        this.soThe = soThe;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getSoThe() {
        return soThe;
    }

    public void setSoThe(String soThe) {
        this.soThe = soThe;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", hoTen='" + hoTen + '\'' +
                ", mssv='" + mssv + '\'' +
                ", khoa='" + khoa + '\'' +
                ", soThe='" + soThe + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
