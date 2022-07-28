package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.AnimalAttiributes;

public interface AnimalAttiributesRepository extends JpaRepository<AnimalAttiributes,Integer> {
    
}
