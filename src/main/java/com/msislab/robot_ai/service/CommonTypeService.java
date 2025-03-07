package com.msislab.robot_ai.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msislab.robot_ai.model.Category;
import com.msislab.robot_ai.model.CommonType;
import com.msislab.robot_ai.repository.CategoryRepository;
import com.msislab.robot_ai.repository.CommonTypeRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CommonTypeService {

    @Autowired
    private CommonTypeRepository commonTypeRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public CommonType createCommonType(CommonType commonType) {
        // Fetch the category by ID
        Optional<Category> categoryOptional = categoryRepository.findById(commonType.getCategory().getId());
        if (!categoryOptional.isPresent()) {
            throw new RuntimeException("Category not found");
        }

        Category category = categoryOptional.get();

        // Set the category
        commonType.setCategory(category);
        commonType.setName(commonType.getName().toUpperCase()); // Ensure the name is uppercase
        //commonType.setCreatedAt(LocalDateTime.now());
        commonType.setUpdatedAt(null); // No update time at creation
        //commonType.setCreatedBy("admin");

        // Save the CommonType entity to the database
        return commonTypeRepository.save(commonType);
    }
}