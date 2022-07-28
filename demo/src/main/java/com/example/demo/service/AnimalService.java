package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Animal;
import com.example.demo.model.AnimalAttiributes;
import com.example.demo.model.AnimalType;
import com.example.demo.utilies.results.DataResult;
import com.example.demo.utilies.results.Result;

public interface AnimalService {
    DataResult<List<Animal>> getAllAnimals();
    DataResult<Animal> getAnimal(int id);
    DataResult<List<AnimalType>> getAnimalTypes();
    Result addAnimal(Animal animal,AnimalAttiributes animalAttiributes);
    Result updateAnimal(Animal animal);
    Result deleteAnimal(int id);
}
