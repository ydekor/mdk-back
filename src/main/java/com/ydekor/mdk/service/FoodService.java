package com.ydekor.mdk.service;

import com.ydekor.mdk.model.Food;
import com.ydekor.mdk.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FoodService {
    private final FoodRepository foodRepository;

    public Food create(Food food) {
        if (food.getId() != null) {
            throw new RuntimeException("id is not allowed here");
        }
        return foodRepository.save(food);
    }

    public Food update(Food food) {
        if (food.getId() == null) {
            throw new RuntimeException("id is required");
        }
        return foodRepository.save(food);
    }

    public void delete(Long id) {
        foodRepository.deleteById(id);
    }

    public Page<Food> getAll(Pageable pageable) {
        return foodRepository.findAll(pageable);
    }
}
