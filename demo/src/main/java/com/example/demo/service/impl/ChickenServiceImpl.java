package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Chicken;
import com.example.demo.repository.ChickenRepository;
import com.example.demo.service.ChickenService;
import com.example.demo.utilies.results.DataResult;
import com.example.demo.utilies.results.ErrorResult;
import com.example.demo.utilies.results.Result;
import com.example.demo.utilies.results.SuccessDataResult;
import com.example.demo.utilies.results.SuccessResult;
@Service
public class ChickenServiceImpl implements ChickenService{

    private ChickenRepository chickenRepository;

    @Autowired
    private ChickenServiceImpl(ChickenRepository chickenRepository){
        super();
        this.chickenRepository = chickenRepository;
    }

    @Override
    public DataResult<List<Chicken>> getAllChickens() {
        return new SuccessDataResult<List<Chicken>>(this.chickenRepository.findAll(),"Successful");
    }

    @Override
    public DataResult<Chicken> getChickenById(int id) {
        return new SuccessDataResult<Chicken>(chickenRepository.getById(id));
    }

    @Override
    public Result updateChicken(Chicken chicken) {
        try {
            if(chickenRepository.getById(chicken.getId()) != null){
                chickenRepository.save(chicken);
            }
            return new SuccessResult("Successfull");
        } catch (Exception e) {
            return new ErrorResult("404");
        }
    }

    @Override
    public Result deleteChicken(int id) {
        try {
            chickenRepository.deleteById(id);
            return new SuccessResult("Successful");
        } catch (Exception e) {
            return new ErrorResult("404");
        }        
    }

    @Override
    public Result addChicken(Chicken chicken) {
        try {
            chickenRepository.save(chicken);
            return new SuccessResult("done");
        } catch (Exception e) {
            return new ErrorResult("Err");
        }
    }
     
}
