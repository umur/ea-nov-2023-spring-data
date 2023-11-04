package com.assignemnts.assignment2.repository;

import com.assignemnts.assignment2.model.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends ListCrudRepository<User, Long> {
}
