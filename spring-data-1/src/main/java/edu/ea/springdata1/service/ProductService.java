package edu.ea.springdata1.service;



import edu.ea.springdata1.dto.FullProductDto;

import java.util.List;

public interface ProductService {
    List<FullProductDto> findAll();
    FullProductDto findById(Integer id) throws Exception;
    FullProductDto add(FullProductDto productDto) throws Exception;
    FullProductDto update(Integer id,FullProductDto productDto) throws Exception;
    boolean delete(Integer id) throws Exception;
}
