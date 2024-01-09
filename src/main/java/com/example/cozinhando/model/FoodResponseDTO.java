package com.example.cozinhando.model;
import java.util.Date;


public record FoodResponseDTO(Long id, String title, String image, String category, String recipe, Integer likes, Date date) {
    public FoodResponseDTO(Food food){
        this(food.getId(), food.getTitle(), food.getImage(), food.getCategory(), food.getRecipe(), food.getLikes(), food.getDate());
    }
}
