package miu.ea.controller;

import miu.ea.entity.Category;
import miu.ea.payload.CategoryDto;
import miu.ea.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Combination of @Controller and @ResponseBody annotations
@RequestMapping("/api/categories") // Base URL for REST API
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

     /*
    Implement CRUD operations for the domains.*/

     // Get all categories REST API
     @GetMapping
     public ResponseEntity<List<CategoryDto>> getAllCategories(){
         return ResponseEntity.ok(categoryService.findAllCategories());
     }

    // create category rest api
    @PostMapping("/create")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        return new ResponseEntity<>(categoryService.createCategory(categoryDto), HttpStatus.CREATED);
    }

    // Get category by {Id} REST API
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable(name = "id") int id){
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    // Update category by {id} REST API
    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,
                                                           @PathVariable(name="id") int id) {

        CategoryDto categoryResponse = categoryService.updateCategory(categoryDto, id);

        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);

    }

    // delete category by {id} REST API
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable(name = "id") int id){

        categoryService.deleteCategoryById(id);

        return new ResponseEntity<>("Category entity deleted successfully.", HttpStatus.OK);
    }


} // End of CategoryController class
