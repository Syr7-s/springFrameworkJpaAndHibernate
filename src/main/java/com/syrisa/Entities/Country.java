package com.syrisa.Entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "country")
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

    public Country(String countryCode, String countryName, String countryContinent, String countryRegion, int countryPopulation, String countryLocalName, String countryGovernmentForm, String countryHeadOfState) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.countryContinent = countryContinent;
        this.countryRegion = countryRegion;
        this.countryPopulation = countryPopulation;
        this.countryLocalName = countryLocalName;
        this.countryGovernmentForm = countryGovernmentForm;
        this.countryHeadOfState = countryHeadOfState;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCoutryContinent() {
        return countryContinent;
    }

    public void setCoutryContinent(String coutryContinent) {
        this.countryContinent = coutryContinent;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }

    public int getCountryPopulation() {
        return countryPopulation;
    }

    public void setCountryPopulation(int countryPopulation) {
        this.countryPopulation = countryPopulation;
    }

    public String getCountryLocalName() {
        return countryLocalName;
    }

    public void setCountryLocalName(String countryLocalName) {
        this.countryLocalName = countryLocalName;
    }

    public String getCountryGovernmentForm() {
        return countryGovernmentForm;
    }

    public void setCountryGovernmentForm(String countryGovernmentForm) {
        this.countryGovernmentForm = countryGovernmentForm;
    }

    public String getCountryHeadOfState() {
        return countryHeadOfState;
    }

    public void setCountryHeadOfState(String countryHeadOfState) {
        this.countryHeadOfState = countryHeadOfState;
    }
}
