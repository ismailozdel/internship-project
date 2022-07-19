package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Chicken;
import com.example.demo.service.ChickenService;
import com.example.demo.utilies.results.DataResult;
import com.example.demo.utilies.results.Result;

@RestController
@RequestMapping("/chicken")
public class ChickenController {
    
    private ChickenService chickenService;
    @Autowired
    public ChickenController(ChickenService chickenService){
        super();
        this.chickenService = chickenService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Chicken>> getAll(){
        return this.chickenService.getAllChickens();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Chicken chicken){
        return chickenService.addChicken(chicken);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id){
        return chickenService.deleteChicken(id);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Chicken chicken){
        return chickenService.updateChicken(chicken);
    }


}
