package com.marketapp.api.subcategory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubcategoryService {

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    List<Subcategory> getCategorySubcategories(Long categoryId){
        return  subcategoryRepository.findSubcategoryByCategoryId(categoryId);
    }

}
