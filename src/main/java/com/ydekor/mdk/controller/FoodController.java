package com.ydekor.mdk.controller;

import com.ydekor.mdk.dto.PaginatedResult;
import com.ydekor.mdk.dto.SimpleResponseDTO;
import com.ydekor.mdk.model.Food;
import com.ydekor.mdk.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor // подгрузить финальные поля
@RestController // аннотация
@RequestMapping("/food") // эндпоинт
public class FoodController {
    private final FoodService foodService;

    @DeleteMapping("/{id}")
    public SimpleResponseDTO deleteRecord(@PathVariable Long id) {
        foodService.delete(id);
        return new SimpleResponseDTO("record id " + id + " deleted success");
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
    public PaginatedResult<Food> getAll(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "size", required = false, defaultValue = "6") int size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return new PaginatedResult<>(foodService.getAll(pageRequest));
    }
}