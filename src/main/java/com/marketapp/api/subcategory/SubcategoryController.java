package com.marketapp.api.subcategory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(
        path = "subcategory"
)
public class SubcategoryController {

    @Autowired
    private SubcategoryService subcategoryService;

    @GetMapping(path = "/{categoryId}")
    List<Subcategory> getCategorySubcategories(@PathVariable("categoryId") Long categoryId){
        return subcategoryService.getCategorySubcategories(categoryId);
    }
}
