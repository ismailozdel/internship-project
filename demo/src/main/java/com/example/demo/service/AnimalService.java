package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Animal;
import com.example.demo.model.Chicken;
import com.example.demo.model.Goat;
import com.example.demo.model.Sheep;
import com.example.demo.utilies.results.DataResult;
import com.example.demo.utilies.results.Result;

public interface AnimalService {
    DataResult<List<Animal>> getAllAnimals();
    DataResult<Animal> getAnimal(int id);
    Result addAnimal(Animal animal);
    Result addAnimal(Chicken animal);
    Result addAnimal(Goat animal);
    Result addAnimal(Sheep animal);
    Result updateAnimal(Animal animal);
    Result updateAnimal(Chicken animal);
    Result updateAnimal(Goat animal);
    Result updateAnimal(Sheep animal);
    Result deleteAnimal(int id);
}
