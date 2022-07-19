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
import com.example.demo.repository.ChickenRepository;
import com.example.demo.repository.GoatRepository;
import com.example.demo.repository.SheepRepository;
import com.example.demo.service.AnimalService;
import com.example.demo.utilies.results.DataResult;
import com.example.demo.utilies.results.SuccessDataResult;
@Service
public class AnimalServiceImpl implements AnimalService{

    private AnimalRepository animalRepository;
    private ChickenRepository chickenRepository;
    private GoatRepository goatRepository;
    private SheepRepository sheepRepository;
    @Autowired
    private AnimalServiceImpl(AnimalRepository animalRepository,ChickenRepository chickenRepository,GoatRepository goatRepository,SheepRepository sheepRepository){
        super();
        this.animalRepository = animalRepository;
        this.chickenRepository = chickenRepository;
        this.goatRepository = goatRepository;
        this.sheepRepository = sheepRepository;
    }

    @Override
    public DataResult<List<Animal>> getAllAnimals() {
        
        List returnValue = new ArrayList();
        
        
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
        return new SuccessDataResult<List<Animal>>(returnValue) ;
    }
    
}
