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
import com.example.demo.model.AnimalAttiributes;
import com.example.demo.model.AnimalType;
import com.example.demo.model.param;
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
    @GetMapping("/get/animalType")
    public DataResult<List<AnimalType>> getAnimalTypes(){
        return this.animalService.getAnimalTypes();
    }

    @PostMapping("/add")
    public Result addAnimal(@RequestBody param param){
        Animal animal = param.getAnimal();
        AnimalAttiributes animalAttiributes = param.getAnimalAttiributes();
        return this.animalService.addAnimal(animal,animalAttiributes);
    }


    @PutMapping("/update")
    public Result update(@RequestBody Animal animal){
        return animalService.updateAnimal(animal);
    }


    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id){
        return animalService.deleteAnimal(id);
    }
}
