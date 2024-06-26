package com.example.crud.repos;

import com.example.crud.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepo extends JpaRepository<Ingredient, Long> {
}
