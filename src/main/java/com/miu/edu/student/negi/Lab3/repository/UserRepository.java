package com.miu.edu.student.negi.Lab3.repository;

import com.miu.edu.student.negi.Lab3.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
