package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "tac_gia")
    private String tacGia;

    @Column(name = "vi_tri")
    private String viTri;

    @Column(name = "ngay_xuat_ban")
    //@Temporal(TemporalType.DATE)
    private String ngayXuatBan;

    public Book() {

    }

    public Book(Integer id, String ten, String tacGia, String viTri, String ngayXuatBan) {
        this.id = id;
        this.ten = ten;
        this.tacGia = tacGia;
        this.viTri = viTri;
        this.ngayXuatBan = ngayXuatBan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public String getNgayXuatBan() {
        return ngayXuatBan;
    }

    public void setNgayXuatBan(String ngayXuatBan) {
        this.ngayXuatBan = ngayXuatBan;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", ten='" + ten + '\'' +
                ", tacGia='" + tacGia + '\'' +
                ", viTri='" + viTri + '\'' +
                ", ngayXuatBan=" + ngayXuatBan +
                '}';
    }
}





