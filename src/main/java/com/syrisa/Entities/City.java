package com.syrisa.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "city")
@Data
@AllArgsConstructor
public class City implements Serializable{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "countryCode")
    private String countryCode;
    @Column(name = "district")
    private String district;
    @Column(name = "population")
    private int population;
    public City(){}

}
