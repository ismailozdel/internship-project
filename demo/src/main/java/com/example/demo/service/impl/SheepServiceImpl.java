package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Sheep;
import com.example.demo.repository.SheepRepository;
import com.example.demo.service.SheepService;
import com.example.demo.utilies.results.DataResult;
import com.example.demo.utilies.results.ErrorResult;
import com.example.demo.utilies.results.Result;
import com.example.demo.utilies.results.SuccessDataResult;
import com.example.demo.utilies.results.SuccessResult;
@Service
public class SheepServiceImpl implements SheepService{

    private SheepRepository sheepRepository;
    public SheepServiceImpl(SheepRepository sheepRepository){
        super();
        this.sheepRepository = sheepRepository;
    }

    @Override
    public DataResult<List<Sheep>> getAllSheeps() {
        return new SuccessDataResult<List<Sheep>>(this.sheepRepository.findAll(),"Successful");
    }

    @Override
    public DataResult<Sheep> getSheepById(int id) {
        return new SuccessDataResult<Sheep>(sheepRepository.getById(id),"Successful");
    }

    @Override
    public Result updateSheep(Sheep sheep) {
        try {
            if(sheepRepository.getById(sheep.getId()) != null){
                sheepRepository.save(sheep);
            }
            return new SuccessResult("Successfull");
        } catch (Exception e) {
            return new ErrorResult("404");
        }
    }

    @Override
    public Result deleteSheep(int id) {
        try {
            sheepRepository.deleteById(id);
            return new SuccessResult("Successful");
        } catch (Exception e) {
            return new ErrorResult("404");
        }     
    }

    @Override
    public Result addSheep(Sheep sheep) {
        try {
            sheepRepository.save(sheep);
            return new SuccessResult("done");
        } catch (Exception e) {
            return new ErrorResult("Err");
        }
    }
    
}
