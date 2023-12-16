package com.cybersoft.cozastore03.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "category")
@Data
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "category")
    private List<ProductEntity> products;
}
