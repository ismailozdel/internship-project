package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Animal;
import com.example.demo.service.AnimalService;
import com.example.demo.utilies.results.DataResult;

@RestController
@RequestMapping("/animal")
public class AnimalController {
    private AnimalService animalService;
    @Autowired
    public AnimalController(AnimalService animalService){
        super();
        this.animalService = animalService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Animal>> getAll(){
        return this.animalService.getAllAnimals();
    }
}
