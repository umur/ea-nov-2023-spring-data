package edu.miu.ea.jpa.service;

import edu.miu.ea.jpa.model.dto.JPCategoryDTO;

import java.util.List;

public interface JPCategoryService {

    JPCategoryDTO add(JPCategoryDTO categoryDto);

    JPCategoryDTO update(Long id, JPCategoryDTO categoryDto) throws Exception;

    List<JPCategoryDTO> findAll();

    JPCategoryDTO findById(Long id) throws Exception;

    boolean retire(Long id) throws Exception;

}
