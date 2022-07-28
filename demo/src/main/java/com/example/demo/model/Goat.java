package com.example.demo.model;
import javax.persistence.*;

@Entity
@Table(name="goat")

public class Goat extends Animal{
	
	@Id
	@Column(name="id")
	private int id;

	@Column(name="animalType")
	private String animalType = "goat";

	public String getAnimalType() {
		return animalType;
	}

	public int getId() {
		return id;
	}
}
