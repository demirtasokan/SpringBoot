package com.example.springbootrestservice.repositories;

import com.example.springbootrestservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
