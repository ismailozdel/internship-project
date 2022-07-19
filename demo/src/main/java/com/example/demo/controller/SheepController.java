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

import com.example.demo.model.Sheep;
import com.example.demo.service.SheepService;
import com.example.demo.utilies.results.DataResult;
import com.example.demo.utilies.results.Result;

@RestController
@RequestMapping("/sheep")
public class SheepController {
    private SheepService sheepService;
    @Autowired
    public SheepController(SheepService sheepService){
        super();
        this.sheepService = sheepService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Sheep>> getAll(){
        return this.sheepService.getAllSheeps();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Sheep sheep){
        return sheepService.addSheep(sheep);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id){
        return sheepService.deleteSheep(id);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Sheep sheep){
        return sheepService.updateSheep(sheep);
    }

}
