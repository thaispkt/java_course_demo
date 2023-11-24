package com.cybersoft.cozastore03.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // GenerationType.IDENTITY =
    // GenerationType.SEQUENCE trong Oracle deu tu dong tang
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "role") // Tên thuộc tisnh của entity bên UserEntity
    // Ten entity chu khong the column name vi UserEntity.java la
    //    private RoleEntity role;
    private List<UserEntity> users;
}
