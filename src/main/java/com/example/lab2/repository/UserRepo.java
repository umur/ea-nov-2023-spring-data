package com.example.lab2.repository;

import com.example.lab2.entity.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends ListCrudRepository<User, Integer> {
}
