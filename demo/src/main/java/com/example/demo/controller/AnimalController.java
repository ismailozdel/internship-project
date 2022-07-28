package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Animal;
import com.example.demo.model.Chicken;
import com.example.demo.model.Goat;
import com.example.demo.model.Sheep;
import com.example.demo.service.AnimalService;
import com.example.demo.utilies.results.DataResult;
import com.example.demo.utilies.results.Result;

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

    @GetMapping("/get")
    public DataResult<Animal> getAnimal(@RequestParam int id){
        return this.animalService.getAnimal(id);
    }

    @PostMapping("/add")
    public Result addAnimal(@RequestBody Animal animal){
        return this.animalService.addAnimal(animal);
    }
    @PostMapping("/add/chicken")
    public Result addAnimal(@RequestBody Chicken animal){
        return this.animalService.addAnimal(animal);
    }
    @PostMapping("/add/goat")
    public Result addAnimal(@RequestBody Goat animal){
        return this.animalService.addAnimal(animal);
    }
    @PostMapping("/add/sheep")
    public Result addAnimal(@RequestBody Sheep animal){
        return this.animalService.addAnimal(animal);
    }


    @PutMapping("/update")
    public Result update(@RequestBody Animal animal){
        return animalService.updateAnimal(animal);
    }
    @PutMapping("/update/chicken")
    public Result update(@RequestBody Chicken animal){
        return animalService.updateAnimal(animal);
    }
    @PutMapping("/update/goat")
    public Result update(@RequestBody Goat animal){
        return animalService.updateAnimal(animal);
    }
    @PutMapping("/update/sheep")
    public Result update(@RequestBody Sheep animal){
        return animalService.updateAnimal(animal);
    }


    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id){
        return animalService.deleteAnimal(id);
    }
}
