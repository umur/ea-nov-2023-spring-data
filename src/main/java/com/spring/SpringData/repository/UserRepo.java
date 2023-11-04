package com.spring.SpringData.repository;

import com.spring.SpringData.domain.entities.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepo extends ListCrudRepository<User, Integer> {

}
