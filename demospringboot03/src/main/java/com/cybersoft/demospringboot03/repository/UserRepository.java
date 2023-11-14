package com.cybersoft.demospringboot03.repository;

import com.cybersoft.demospringboot03.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UsersEntity, Integer> { // chứa các câu
    // query, tự động mở kết nối database
    // Controller: chỉ định nghĩa path và lấy paramer
    // Service: logic code
    // repository: chứa các câu truy vấn SQL
    List<UsersEntity> findByEmailAndPassword(String email, String password);
}
