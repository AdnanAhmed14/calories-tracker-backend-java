package com.calories.tracker.controller;

import com.calories.tracker.model.APIResponse;
import com.calories.tracker.entity.Calories;
import com.calories.tracker.model.CaloriesDto;
import com.calories.tracker.model.MealTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.calories.tracker.service.CaloriesServices;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CaloriesController {
    @Autowired
    CaloriesServices caloriesServices;

    @PostMapping("/addCalories")
    public APIResponse<Void> addCalories(@RequestBody CaloriesDto caloriesDto){
        try {
            caloriesServices.addCalories(caloriesDto);
            return APIResponse.success();
        }
        catch (Exception e){
            return APIResponse.error(e.getMessage());
        }
    }
    @GetMapping("/test")
    public String test(){
        return "Test";
    }
        @GetMapping("/getAll/{mealTime}")
    public APIResponse<List<Calories>> getCalories(@PathVariable MealTime mealTime){
        try {
            List<Calories> caloriesList = caloriesServices.getCalories(mealTime);
            return APIResponse.success(caloriesList);
        }catch (Exception e){
            return APIResponse.error(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public APIResponse<Void> deleteCalories(@PathVariable Long id){
        try {
            caloriesServices.deleteCalories(id);
            return APIResponse.success();

        }catch (Exception e){
            return APIResponse.error(e.getMessage());
        }
    }
    @GetMapping("/all")
    public APIResponse<List<Calories>> getAll(){
        try {
            List<Calories> all= caloriesServices.getAll();
            return APIResponse.success(all);

        }catch (Exception e){
            return APIResponse.error(e.getMessage());
        }
    }
}
