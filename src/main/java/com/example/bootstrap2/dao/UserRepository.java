package com.example.bootstrap2.dao;


import com.example.bootstrap2.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findById(long id);
    User findByUserName(String userName);

}