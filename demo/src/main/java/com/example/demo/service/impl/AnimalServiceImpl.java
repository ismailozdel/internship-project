package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Chicken;
import com.example.demo.model.Goat;
import com.example.demo.model.Sheep;
import com.example.demo.model.Animal;
import com.example.demo.repository.AnimalRepository;
/* import com.example.demo.repository.ChickenRepository;
import com.example.demo.repository.GoatRepository;
import com.example.demo.repository.SheepRepository; */
import com.example.demo.service.AnimalService;
import com.example.demo.utilies.results.DataResult;
import com.example.demo.utilies.results.ErrorDataResult;
import com.example.demo.utilies.results.ErrorResult;
import com.example.demo.utilies.results.Result;
import com.example.demo.utilies.results.SuccessDataResult;
import com.example.demo.utilies.results.SuccessResult;
@Service
public class AnimalServiceImpl implements AnimalService{

    private AnimalRepository animalRepository;
/*     private ChickenRepository chickenRepository;
    private GoatRepository goatRepository;
    private SheepRepository sheepRepository; */
    @Autowired
    private AnimalServiceImpl(AnimalRepository animalRepository/* ,ChickenRepository chickenRepository,GoatRepository goatRepository,SheepRepository sheepRepository */){
        super();
        this.animalRepository = animalRepository;
/*         this.chickenRepository = chickenRepository;
        this.goatRepository = goatRepository;
        this.sheepRepository = sheepRepository; */
    }

    @Override
    public DataResult<List<Animal>> getAllAnimals() {
        
        /* List returnValue = new ArrayList();
        
        
        List<Chicken> chickens = chickenRepository.findAll();
        Map<String,Integer> chickenMap = new HashMap<String,Integer>();
        chickenMap.put("Chicken Count", chickens.size());
        returnValue.addAll(chickens);
        returnValue.add(chickenMap);
        
        
        List<Goat> goats = goatRepository.findAll();
        Map<String,Integer> goatMap = new HashMap<String,Integer>();
        goatMap.put("Goat Count", goats.size());
        returnValue.addAll(goats);
        returnValue.add(goatMap);


        List<Sheep> sheeps = sheepRepository.findAll();
        Map<String,Integer> sheepMap = new HashMap<String,Integer>();
        sheepMap.put("Sheep Count", sheeps.size());
        returnValue.addAll(sheeps);
        returnValue.add(sheepMap);
        return new SuccessDataResult<List<Animal>>(returnValue) ; */
        return new ErrorDataResult<>("s");
    }

    @Override
    public DataResult<Animal> getAnimal(int id) {
        return new SuccessDataResult<Animal>(animalRepository.findById(id).get());
    }

    @Override
    public Result addAnimal(Animal animal) {
        animalRepository.save(animal);
        return new SuccessResult("cond");
    }

    @Override
    public Result addAnimal(Chicken animal) {
        animalRepository.save(animal);
        return new SuccessResult("cond");
    }

    @Override
    public Result addAnimal(Goat animal) {
        animalRepository.save(animal);
        return new SuccessResult("cond");
    }

    @Override
    public Result addAnimal(Sheep animal) {
        animalRepository.save(animal);
        return new SuccessResult("cond");
    }

    @Override
    public Result updateAnimal(Animal animal) {
        try {
            if(animalRepository.getById(animal.getId()) != null){
                animalRepository.save(animal);
            }
            return new SuccessResult("Successfull");
        } catch (Exception e) {
            return new ErrorResult("404");
        }
    }

    @Override
    public Result updateAnimal(Chicken animal) {
        try {
            if(animalRepository.getById(animal.getId()) != null){
                animalRepository.save(animal);
            }
            return new SuccessResult("Successfull");
        } catch (Exception e) {
            return new ErrorResult("404");
        }
    }

    @Override
    public Result updateAnimal(Goat animal) {
        try {
            if(animalRepository.getById(animal.getId()) != null){
                animalRepository.save(animal);
            }
            return new SuccessResult("Successfull");
        } catch (Exception e) {
            return new ErrorResult("404");
        }
    }

    @Override
    public Result updateAnimal(Sheep animal) {
        try {
            if(animalRepository.getById(animal.getId()) != null){
                animalRepository.save(animal);
            }
            return new SuccessResult("Successfull");
        } catch (Exception e) {
            return new ErrorResult("404");
        }
    }

    @Override
    public Result deleteAnimal(int id) {
        try {
            animalRepository.deleteById(id);
            return new SuccessResult("Successfull");
        } catch (Exception e) {
            return new ErrorResult("404");
        }
    }


    
    
}
