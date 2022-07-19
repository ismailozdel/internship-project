package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Animal;
import com.example.demo.utilies.results.DataResult;

public interface AnimalService {
    DataResult<List<Animal>> getAllAnimals();
    
}
