package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Sheep;
import com.example.demo.utilies.results.DataResult;
import com.example.demo.utilies.results.Result;

public interface SheepService {
    DataResult<List<Sheep>> getAllSheeps();
    DataResult<Sheep> getSheepById(int id);
    Result updateSheep(Sheep sheep);
    Result deleteSheep(int id);
    Result addSheep(Sheep sheep);
}
