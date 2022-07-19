package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Goat;

public interface GoatRepository extends JpaRepository<Goat,Integer>{
    Goat getById(int id);
}
