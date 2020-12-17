package com.syrisa.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "country")
@Data

public class Country implements Serializable {
    @Id
    @Column(name = "Code")
    private String countryCode;
    @Column(name = "Name")
    private String countryName;
    @Column(name="Continent")
    private String countryContinent;
    @Column(name = "Region")
    private String countryRegion;
    @Column(name = "Population")
    private int countryPopulation;
    @Column(name="LocalName")
    private String countryLocalName;
    @Column(name = "GovernmentForm")
    private String countryGovernmentForm;
    @Column(name="HeadOfState")
    private String countryHeadOfState;
    public Country(){}

}
