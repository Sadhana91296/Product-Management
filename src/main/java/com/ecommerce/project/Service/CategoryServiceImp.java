package com.ecommerce.project.Service;

import com.ecommerce.project.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService{
    private List<Category> categories=new ArrayList<>();
    Long next=1L;
    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public String createCategory(Category category) {
        category.setCategoryId(next++);
        categories.add(category);
        return "Category added successfully";
    }

    @Override
    public String deleteCategory(Long categoryId) {
       Category category= categories.stream().filter(c->c.getCategoryId().equals(categoryId)).findFirst().orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource Not found"));
       if(category==null)
           return "Category not found";
       categories.remove(category);
       return "Category with categoryId "+ categoryId+" successfully deleted";
    }

    @Override
    public Category updateCategory(Long categoryId,Category category) {
        Category status=categories.stream().filter(c->c.getCategoryId().equals(categoryId)).findFirst().orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid ID"));
        status.setCategoryName(category.getCategoryName());
        return status;
    }
}
