package com.miu.lab3restfullwebservice.repository;

import com.miu.lab3restfullwebservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}