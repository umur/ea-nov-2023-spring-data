package com.example.lab2.repository;

import com.example.lab2.entity.ActivityLog;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepo extends ListCrudRepository<ActivityLog, Integer> {

}
