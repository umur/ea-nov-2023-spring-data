package edu.miu.ea.jpa.controller;

import edu.miu.ea.jpa.model.dto.JPCategoryDTO;
import edu.miu.ea.jpa.service.JPCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class JPCategoryController {

    private final JPCategoryService service;

    @PostMapping
    JPCategoryDTO add(@RequestBody JPCategoryDTO categoryDTO) {
        return service.add(categoryDTO);
    }

    @PutMapping("/{id}")
    JPCategoryDTO update(@PathVariable Long id, @RequestBody JPCategoryDTO categoryDTO) throws Exception {
        return service.update(id, categoryDTO);
    }

    @DeleteMapping("/{id}")
    Boolean retire(@PathVariable Long id) throws Exception {
        return service.retire(id);
    }

    @GetMapping
    List<JPCategoryDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/search")
    JPCategoryDTO findById(@RequestParam Long id) throws Exception {
        return service.findById(id);
    }

}

