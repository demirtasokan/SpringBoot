package com.example.Chapter6.mappers;

import com.example.Chapter6.domain.User;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

public interface UserAnnotationMapper {

  @Insert("insert into users(name,email) values(#{name},#{email})")
  @SelectKey(statement="call identity()", resultType = int.class, before = false, keyProperty = "id")
  @Options(useGeneratedKeys=true, keyColumn="id")
  void insertUser(User user);

  @Select("select id, name, email from users WHERE id=#{id}")
  User findUserById(Integer id);

  @Select("select id, name, email from users")
  List<User> findAllUsers();
}
