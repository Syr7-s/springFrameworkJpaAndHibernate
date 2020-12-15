package com.syrisa.controller;

import com.syrisa.Entities.Country;
import com.syrisa.Service.Abstract.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    private ICountryService countryService;
    @Autowired
    public CountryController(ICountryService countryService){
        this.countryService=countryService;
    }

    @GetMapping("/allCountry")
    public String get(){
        List<Country> countryList=countryService.getAll();
        for (Country country:countryList) {
            System.out.println(country.getCountryCode()+" "+
                    country.getCountryName()+" "+
                    country.getCoutryContinent()+" "+
                    country.getCountryRegion()+" "+
                    country.getCountryPopulation()+" "+
                    country.getCountryLocalName()+" "+
                    country.getCountryGovernmentForm()+" "+
                    country.getCountryHeadOfState());
        }
        return "Tum country getirildi";
    }
}
