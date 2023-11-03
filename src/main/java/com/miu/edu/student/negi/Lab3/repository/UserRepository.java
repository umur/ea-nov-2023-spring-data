package com.miu.edu.student.negi.Lab3.repository;

import com.miu.edu.student.negi.Lab3.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
}
