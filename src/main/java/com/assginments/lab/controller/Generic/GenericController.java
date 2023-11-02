package com.assginments.lab.controller.Generic;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assginments.lab.dto.Generic.GenericDto;
import com.assginments.lab.dto.Generic.GenericNewDto;
import com.assginments.lab.entity.Generic.GenericEntity;
import com.assginments.lab.service.Generic.GenericService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class GenericController<TEntity extends GenericEntity, TDto extends GenericDto, TNewEntityDto extends GenericNewDto, TService extends GenericService<TEntity, TDto, TNewEntityDto>> {
    private final TService service;

    // findAll
    @GetMapping
    public List<TDto> findAll() {
        return service.findAll();
    }

    // findById
    @GetMapping("{id}")
    public TDto findByid(@PathVariable int id) {
        return service.findById(id);
    }

    // Add
    @PostMapping
    public void addNew(@RequestBody TNewEntityDto entityDto) {
        service.add(entityDto);
    }

    // update
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody TNewEntityDto updatedDto) {
        service.update(id, updatedDto);
    }

    // remove
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        service.remove(id);
    }
}
