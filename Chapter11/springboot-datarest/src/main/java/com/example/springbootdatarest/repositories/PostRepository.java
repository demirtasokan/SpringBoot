package com.example.springbootdatarest.repositories;

import com.example.springbootdatarest.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {

}
