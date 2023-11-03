package com.example.lab3.Repository;

import com.example.lab3.Model.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends ListCrudRepository<User,Integer> {
    User findById(int id);

    User updateById(int id,User user);
    void deleteById(int id);
}
