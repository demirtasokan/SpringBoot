package com.example.springbootrestservice.repositories;

import com.example.springbootrestservice.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer>{

}
