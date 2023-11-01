package com.assginments.lab.repository;

import org.springframework.data.repository.CrudRepository;

import com.assginments.lab.entity.User;

public interface UserRepo extends CrudRepository<User, Integer> {

}
