package com.example.cozinhando.controller;


import com.example.cozinhando.model.Food;
import com.example.cozinhando.model.FoodRepository;
import com.example.cozinhando.model.FoodRequestDTO;
import com.example.cozinhando.model.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("food")
public class FoodController {


    @Autowired
    private FoodRepository repository;


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        repository.save(foodData);
        return;
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll(){


        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/recent")
    public List<FoodResponseDTO> getRecentFoods() {
        List<FoodResponseDTO> recentFoods = repository.findTop6ByOrderByDateDesc().stream().map(FoodResponseDTO::new).toList();
        return recentFoods;
    }

    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
