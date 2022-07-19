package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Sheep;

public interface SheepRepository extends JpaRepository<Sheep,Integer>{
    Sheep getById(int id);
}
