package com.example.springbootdatarest.repositories;

import com.example.springbootdatarest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
