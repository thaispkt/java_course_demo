package com.cybersoft.cozastore03.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // GenerationType.IDENTITY =
    // GenerationType.SEQUENCE trong Oracle deu tu dong tang
    private int id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @ManyToOne // nhieu user chi co 1 role, thang nao la chu N (giu khoa ngoai) thi luon la
    // @ManyToOne, @JoinColumn (column name trong database)
    // Neu chu cuoi la One thi se la 1 doi tuong cua Entity tham chieu toi
    // Neu chu cuoi la Many thi se la 1 list doi tuong cua Entity tham chieu toi
    @JoinColumn(name = "id_role")
    private RoleEntity role;
//    private int id_role;
}
