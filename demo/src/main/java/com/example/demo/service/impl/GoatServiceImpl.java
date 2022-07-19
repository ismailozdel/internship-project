package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Goat;
import com.example.demo.repository.GoatRepository;
import com.example.demo.service.GoatService;
import com.example.demo.utilies.results.DataResult;
import com.example.demo.utilies.results.ErrorResult;
import com.example.demo.utilies.results.Result;
import com.example.demo.utilies.results.SuccessDataResult;
import com.example.demo.utilies.results.SuccessResult;

@Service
public class GoatServiceImpl implements GoatService{

    private GoatRepository goatRepository;
    @Autowired
    public GoatServiceImpl(GoatRepository goatRepository){
        super();
        this.goatRepository = goatRepository;
    }

    @Override
    public DataResult<List<Goat>> getAllGoats() {
        return new SuccessDataResult<List<Goat>>(goatRepository.findAll(), "Success"); 
    }

    @Override
    public DataResult<Goat> getGoatById(int id) {
        return new SuccessDataResult<Goat>(goatRepository.getById(id),"Success");
    }

    @Override
    public Result updateGoat(Goat goat) {
        try {
            if(goatRepository.getById(goat.getId()) != null){
                goatRepository.save(goat);
            }
            return new SuccessResult("Successfull");
        } catch (Exception e) {
            return new ErrorResult("404");
        }
    }

    @Override
    public Result deleteGoat(int id) {
        try {
            goatRepository.deleteById(id);
            return new SuccessResult("Successful");
        } catch (Exception e) {
            return new ErrorResult("404");
        }    
    }

    @Override
    public Result addGoat(Goat goat) {
        try {
            goatRepository.save(goat);
            return new SuccessResult("done");
        } catch (Exception e) {
            return new ErrorResult("Err");
        }
    }
    
    
}
