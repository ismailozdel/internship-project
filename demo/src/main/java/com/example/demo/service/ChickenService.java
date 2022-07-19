package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Chicken;
import com.example.demo.utilies.results.DataResult;
import com.example.demo.utilies.results.Result;

public interface ChickenService {
    DataResult<List<Chicken>> getAllChickens();
    DataResult<Chicken> getChickenById(int id);
    Result updateChicken(Chicken chicken);
    Result deleteChicken(int id);
    Result addChicken(Chicken chicken);
}
