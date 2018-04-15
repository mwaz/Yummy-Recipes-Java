package com.yummyrecipe.Yummy.Recipes.repository;
import com.yummyrecipe.Yummy.Recipes.model.Recipes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipes, Long> {

}
