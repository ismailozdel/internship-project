package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="animal_attiributes")
public class AnimalAttiributes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDailyEggProduction() {
        return dailyEggProduction;
    }

    public void setDailyEggProduction(int dailyEggProduction) {
        this.dailyEggProduction = dailyEggProduction;
    }

    @Column(name="daily_egg_production")
    private int dailyEggProduction;
}
