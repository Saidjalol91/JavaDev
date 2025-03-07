package com.msislab.robot_ai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msislab.robot_ai.model.Category;
import com.msislab.robot_ai.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        if (category.getName() == null || category.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Category name is required and it cannot be empty");
        }

        category.setName(category.getName().toUpperCase());
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long categoryId, Category categoryUpdate) {
        Optional<Category> existingCategory = categoryRepository.findById(categoryId);

        if (existingCategory.isEmpty()) {
            throw new IllegalArgumentException("Category not found");
        }

        Category category = existingCategory.get();

        if (categoryUpdate.getName() != null && !categoryUpdate.getName().trim().isEmpty()) {
            category.setName(categoryUpdate.getName().toUpperCase()); // Convert name to uppercase
        }

        return categoryRepository.save(category); // Save the updated category
    }
}