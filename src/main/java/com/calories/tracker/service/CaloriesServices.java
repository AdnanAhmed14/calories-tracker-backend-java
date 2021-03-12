package com.calories.tracker.service;

import com.calories.tracker.entity.Calories;
import com.calories.tracker.model.CaloriesDto;
import com.calories.tracker.model.MealTime;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.calories.tracker.repository.CaloriesRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CaloriesServices {
    @Autowired
    CaloriesRepository caloriesRepository;
    @Autowired
    ModelMapper modelMapper;

    public void addCalories(CaloriesDto caloriesDto){
        Calories calories = generateEntity(caloriesDto);
        caloriesRepository.save(calories);
    }

    private Calories generateEntity(CaloriesDto caloriesDto) {
        return modelMapper.map(caloriesDto, Calories.class);
    }
    public List<Calories> getCalories(MealTime mealTime){
        return caloriesRepository.findAllByMealTime(mealTime);
    }
    public void deleteCalories(Long id){
        Calories calories = caloriesRepository.findById(id).orElseThrow(NoSuchElementException::new);
        caloriesRepository.delete(calories);
    }

    public List<Calories> getAll() {
        return caloriesRepository.findAll();
    }
}
