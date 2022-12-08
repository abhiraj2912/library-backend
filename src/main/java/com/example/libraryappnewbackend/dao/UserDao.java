package com.example.libraryappnewbackend.dao;

import com.example.libraryappnewbackend.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends CrudRepository<Users, Integer> {

    @Query(value = "SELECT `id`, `aadharno`, `address`, `dob`, `email`, `name`, `password`, `phone`, `pincode`, `username` FROM `users` WHERE `username`= :username AND `password` = :password",nativeQuery = true)
    List<Users> LoginCheck(@Param("username") String username, @Param("password") String password);


}
