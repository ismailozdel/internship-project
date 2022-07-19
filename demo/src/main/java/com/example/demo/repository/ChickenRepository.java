package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Chicken;

public interface ChickenRepository extends JpaRepository<Chicken,Integer>{
    Chicken getById(int id);
}
