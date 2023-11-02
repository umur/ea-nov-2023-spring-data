package com.assginments.lab.repository.Generic;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericRepo<TEntity> extends CrudRepository<TEntity, Integer> {

}
