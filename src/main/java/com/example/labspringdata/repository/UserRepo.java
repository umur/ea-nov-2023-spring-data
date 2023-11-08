package com.example.labspringdata.repository;

import com.example.labspringdata.entity.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepo extends ListCrudRepository<User,Integer> {
}
