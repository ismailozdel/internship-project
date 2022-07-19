package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Goat;
import com.example.demo.utilies.results.DataResult;
import com.example.demo.utilies.results.Result;

public interface GoatService {
    DataResult<List<Goat>> getAllGoats();
    DataResult<Goat> getGoatById(int id);
    Result updateGoat(Goat goat);
    Result deleteGoat(int id);
    Result addGoat(Goat goat);
}
