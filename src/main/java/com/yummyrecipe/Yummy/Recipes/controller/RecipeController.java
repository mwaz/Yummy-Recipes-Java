package com.yummyrecipe.Yummy.Recipes.controller;
import java.util.List;
import com.yummyrecipe.Yummy.Recipes.exception.ResourceNotFoundException;
import com.yummyrecipe.Yummy.Recipes.model.Recipes;
import com.yummyrecipe.Yummy.Recipes.repository.RecipeRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class RecipeController {

    @Autowired
    RecipeRepository recipeRepository;

    //Create a new Recipe
    @PostMapping("/recipes")
    public Recipes createRecipe(@Valid @RequestBody Recipes recipe) {
        return  recipeRepository.save(recipe);
    }

    //Get all recipes
    @GetMapping("/recipes")
    public List<Recipes> getAllRecipes(){
        return  recipeRepository.findAll();
    }


    //Get a single note
    @GetMapping("/recipes/{id}")
    public Recipes getRecipeById(@PathVariable(value = "id") Long recipeId) {
        return  recipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe", "id", recipeId));
    }

    //Update a note
    @PutMapping("recipes/{id}")
    public Recipes updateRecipe(@PathVariable(value = "id") Long recipeId, @Valid @RequestBody
    Recipes recipeDetails) {
        Recipes recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe", "id", recipeId));

        recipe.setRecipeName(recipeDetails.getRecipeName());
        recipe.setRecipeDetails(recipeDetails.getRecipeDetails());

        Recipes updatedRecipe = recipeRepository.save(recipe);
        return  updatedRecipe;
    }


// Delete some recipe
    @DeleteMapping("recipes/{id}")
    public ResponseEntity <?> deleteRecipe(@PathVariable(value = "id") Long recipeId) {
        Recipes recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe", "id", recipeId));

        recipeRepository.delete(recipe);
        return ResponseEntity.ok().build();
    }

}
