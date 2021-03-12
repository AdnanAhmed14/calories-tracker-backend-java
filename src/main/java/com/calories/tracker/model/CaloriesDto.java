package com.calories.tracker.model;

import lombok.Data;

@Data
public class CaloriesDto {
    private String itemName;
    private Long calories;
    private MealTime mealTime;
}
