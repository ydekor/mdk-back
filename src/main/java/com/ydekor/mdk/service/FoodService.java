package com.ydekor.mdk.service;

import com.ydekor.mdk.model.Food;
import com.ydekor.mdk.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FoodService {
    private final FoodRepository foodRepository;
    public void create() {
        Food food = Food
                .builder()
                .cost(300)
                .name("kokoko")
                .build();
        foodRepository.save(food);
    }

    public List<Food> getAll() {
        return foodRepository.findAll();
    }
}
