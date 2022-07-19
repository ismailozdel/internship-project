package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="sheep")
public class Sheep extends Animal{
    @Id
    @Column(name="id")
    private int id;

    public int getId() {
        return id;
    }


}
