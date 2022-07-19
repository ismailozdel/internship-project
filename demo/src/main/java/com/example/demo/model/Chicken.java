package com.example.demo.model;
import javax.persistence.*;

@Entity
@Table(name="chicken")

public class Chicken extends Animal{
	
	@Id
	@Column(name="id")
	private int id;

	@Column(name="daily_egg_production")
	private int dailyEggProduction;

	public int getId() {
		return id;
	}

	public int getDailyEggProduction() {
		return dailyEggProduction;
	}

	public void setDailyEggProduction(int dailyEggProduction) {
		this.dailyEggProduction = dailyEggProduction;
	}


}
