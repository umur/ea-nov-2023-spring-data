package edu.miu.ea.jpa.service;

import edu.miu.ea.jpa.model.dto.JPProductDTO;

import java.util.List;

public interface JPProductService {

    JPProductDTO add(JPProductDTO productDTO) throws Exception;

    JPProductDTO update(Long id, JPProductDTO productDTO) throws Exception;

    List<JPProductDTO> findAll();

    JPProductDTO findById(Long id) throws Exception;

    boolean retire(Long id) throws Exception;

}
