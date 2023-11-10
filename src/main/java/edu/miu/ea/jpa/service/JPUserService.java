package edu.miu.ea.jpa.service;

import edu.miu.ea.jpa.model.dto.JPUserDTO;

import java.util.List;

public interface JPUserService {

    JPUserDTO add(JPUserDTO userDto);

    JPUserDTO update(Long id, JPUserDTO userDto) throws Exception;

    List<JPUserDTO> findAll();

    JPUserDTO findById(Long id) throws Exception;

    boolean retire(Long id) throws Exception;

}
