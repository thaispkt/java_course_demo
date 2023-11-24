package com.cybersoft.cozastore03.repository;

import com.cybersoft.cozastore03.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // phai dua len IOC
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    UserEntity findByEmail(String email); // Do kq tra ve 1 row, nen ta ko khai bao thanh list
    // Users, con neu lo tra ve 1 list thi se lay doi tuong dau tien cua list


}
