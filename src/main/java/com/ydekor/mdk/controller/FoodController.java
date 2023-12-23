package com.ydekor.mdk.controller;

import com.ydekor.mdk.model.Food;
import com.ydekor.mdk.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController // аннотация
@RequestMapping("/") // эндпоинт
public class FoodController {
    private final FoodService foodService;
    @GetMapping // обработка get запросов
    public List<Food> getAll() {
        return foodService.getAll();
    }
}