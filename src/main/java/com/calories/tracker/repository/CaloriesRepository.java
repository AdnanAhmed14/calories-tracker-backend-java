package com.calories.tracker.repository;

import com.calories.tracker.entity.Calories;
import com.calories.tracker.model.MealTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaloriesRepository extends JpaRepository<Calories, Long> {
    List<Calories> findAllByMealTime(MealTime mealTime);

}
