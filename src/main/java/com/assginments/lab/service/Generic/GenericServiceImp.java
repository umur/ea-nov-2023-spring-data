package com.assginments.lab.service.Generic;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import com.assginments.lab.dto.Generic.GenericDto;
import com.assginments.lab.dto.Generic.GenericNewDto;
import com.assginments.lab.entity.Generic.GenericEntity;
import com.assginments.lab.repository.Generic.GenericRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GenericServiceImp<TEntity extends GenericEntity, TDto extends GenericDto, TNewEntityDto extends GenericNewDto, TRepo extends GenericRepo<TEntity>>
        implements GenericService<TEntity, TDto, TNewEntityDto> {

    private final TRepo repo;
    private final ModelMapper mapper;

    // findAll
    public List<TDto> findAll() {
        var entity = repo.findAll();
        List<TDto> result = mapper.map(entity, new TypeToken<List<TDto>>() {
        }.getType());
        return result;
    }

    // findById
    public TDto findById(int id) {
        var entity = repo.findById(id);
        if (entity.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }

        return mapper.map(entity, new TypeToken<TDto>() {
        }.getType());
    }

    // Add
    public void add(TNewEntityDto newEntityDto) {
        TEntity entity = mapper.map(newEntityDto, new TypeToken<TEntity>() {
        }.getType());

        repo.save(entity);
    }

    // update
    public void update(int id, TNewEntityDto updatedAddressDto) {
        if (!repo.existsById(id)) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        TEntity entity = mapper.map(updatedAddressDto, new TypeToken<TEntity>() {
        }.getType());

        entity.setId(id);
        repo.save(entity);
    }

    // remove
    public void remove(int id) {
        if (!repo.existsById(id)) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        repo.deleteById(id);
    }

}
