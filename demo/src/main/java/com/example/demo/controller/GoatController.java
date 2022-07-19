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

import com.example.demo.model.Goat;
import com.example.demo.service.GoatService;
import com.example.demo.utilies.results.DataResult;
import com.example.demo.utilies.results.Result;

@RestController
@RequestMapping("/goat")
public class GoatController {
    private GoatService goatService;
    @Autowired
    public GoatController(GoatService goatService){
        super();
        this.goatService = goatService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Goat goat){
        System.out.println("i");
        return goatService.addGoat(goat);
    }

    @GetMapping("/getAll")
    public DataResult<List<Goat>> getAll(){
        return goatService.getAllGoats();
    }
    
    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id){
        return goatService.deleteGoat(id);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Goat goat){
        return goatService.updateGoat(goat);
    }
}
