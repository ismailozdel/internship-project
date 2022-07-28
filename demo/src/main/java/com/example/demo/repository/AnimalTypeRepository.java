package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.AnimalType;

public interface AnimalTypeRepository extends JpaRepository<AnimalType,Integer>{
    
}
