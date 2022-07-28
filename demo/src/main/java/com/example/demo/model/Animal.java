package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="animals")

public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	

	@Column(name="name")
	private String name;
	
	@Column(name="age")
	private int age;

	@ManyToOne
	private AnimalType animalType;

	@ManyToOne
	private AnimalAttiributes animalAttiributes;

	
	public AnimalAttiributes getAnimalAttiributes() {
		return animalAttiributes;
	}

	public void setAnimalAttiributes(AnimalAttiributes animalAttiributes) {
		this.animalAttiributes = animalAttiributes;
	}

	public AnimalType getAnimalType() {
		return animalType;
	}

	public void setAnimalType(AnimalType animalType) {
		this.animalType = animalType;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Animal(int id, String name, int age, AnimalType animalType,AnimalAttiributes animalAttiributes) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.animalType = animalType;
		this.animalAttiributes = animalAttiributes;
	}
	public Animal(){
		super();
	}
}
