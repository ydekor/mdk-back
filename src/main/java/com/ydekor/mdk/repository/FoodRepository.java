package com.ydekor.mdk.repository;

import com.ydekor.mdk.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

//обращение к базе данных
public interface FoodRepository extends JpaRepository<Food, Long> {

}
