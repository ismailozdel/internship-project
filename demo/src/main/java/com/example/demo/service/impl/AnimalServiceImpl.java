package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Animal;
import com.example.demo.model.AnimalAttiributes;
import com.example.demo.model.AnimalType;
import com.example.demo.repository.AnimalAttiributesRepository;
import com.example.demo.repository.AnimalRepository;
import com.example.demo.repository.AnimalTypeRepository;
import com.example.demo.service.AnimalService;
import com.example.demo.utilies.results.DataResult;
import com.example.demo.utilies.results.ErrorResult;
import com.example.demo.utilies.results.Result;
import com.example.demo.utilies.results.SuccessDataResult;
import com.example.demo.utilies.results.SuccessResult;
@Service
public class AnimalServiceImpl implements AnimalService{

    private AnimalRepository animalRepository;
    private AnimalAttiributesRepository animalAttiributesRepository;
    private AnimalTypeRepository animalTypeRepository;

    @Autowired
    private AnimalServiceImpl(AnimalRepository animalRepository,AnimalAttiributesRepository animalAttiributesRepository,AnimalTypeRepository animalTypeRepository){
        super();
        this.animalRepository = animalRepository;
        this.animalAttiributesRepository = animalAttiributesRepository;
        this.animalTypeRepository = animalTypeRepository;
    }

    @Override
    public DataResult<List<Animal>> getAllAnimals() {
        return new SuccessDataResult<List<Animal>>(animalRepository.findAll(),"done");
    }

    @Override
    public DataResult<Animal> getAnimal(int id) {
        return new SuccessDataResult<Animal>(animalRepository.findById(id).get());
    }

    @Override
    public DataResult<List<AnimalType>> getAnimalTypes() {
        List returnValue = new ArrayList();
        List<AnimalType> animalTypes = animalTypeRepository.findAll();
        for (AnimalType animalType : animalTypes) {
            Map<String,Integer> animalMap = new HashMap<String,Integer>();
            List<Animal> animals = animalRepository.findByAnimalTypeId(animalType.getId());
            animalMap.put(animalType.getType(), animals.size());
            returnValue.addAll(animals);
            returnValue.add(animalMap);
        }
        return new SuccessDataResult<List<AnimalType>>(returnValue, "done");
    }

    @Override
    public Result addAnimal(Animal animal,AnimalAttiributes animalAttiributes) {
        animalAttiributes = animalAttiributesRepository.saveAndFlush(animalAttiributes);
        animal.setAnimalAttiributes(animalAttiributes);
        animalRepository.save(animal);
        
        return new SuccessResult("cond");
    }

    @Override
    public Result updateAnimal(Animal animal) {
        try {
            if(animalRepository.findById(animal.getId()).get() != null){
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
