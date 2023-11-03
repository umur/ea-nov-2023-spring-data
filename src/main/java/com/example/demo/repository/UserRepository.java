package com.example.demo.repository;

import com.example.demo.entity.Address;
import com.example.demo.entity.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ListCrudRepository<User, Integer> {


}