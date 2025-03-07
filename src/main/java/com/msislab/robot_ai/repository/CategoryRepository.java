package com.msislab.robot_ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msislab.robot_ai.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}