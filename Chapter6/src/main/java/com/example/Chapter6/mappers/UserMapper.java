package com.example.Chapter6.mappers;

import com.example.Chapter6.domain.User;
import java.util.List;

public interface UserMapper {

  void insertUser(User user);

  User findUserById(Integer id);

  List<User> findAllUsers();

}
