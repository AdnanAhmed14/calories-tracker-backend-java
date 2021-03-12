package com.calories.tracker.entity;

import lombok.Data;
import com.calories.tracker.model.MealTime;

import javax.persistence.*;

@Data
@Entity
public class Calories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemName;
    private Long calories;
    private MealTime mealTime;
}
