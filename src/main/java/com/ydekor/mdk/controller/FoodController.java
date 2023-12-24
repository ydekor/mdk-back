package com.ydekor.mdk.controller;

import com.ydekor.mdk.model.Food;
import com.ydekor.mdk.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor // подгрузить финальные поля
@RestController // аннотация
@RequestMapping("/food") // эндпоинт
public class FoodController {
    private final FoodService foodService;

    @DeleteMapping("/{id}")
    public String deleteRecord(@PathVariable Long id) {
        foodService.delete(id);
        return "record id " + id + " deleted success";
    }

    @PutMapping
    public Food updateRecord(@RequestBody Food food) {
        return foodService.update(food);
    }

    @PostMapping
    public Food createRecord(@RequestBody Food food) {
        return foodService.create(food);
    }

    @GetMapping // обработка get запросов
    public List<Food> getAll() {
        return foodService.getAll();
    }
}