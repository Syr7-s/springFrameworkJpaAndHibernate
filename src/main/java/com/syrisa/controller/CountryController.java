package com.syrisa.controller;

import com.syrisa.Entities.Country;
import com.syrisa.Service.Abstract.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private ICountryService countryService;

    @GetMapping("/allCountry")
    public String get(){
        List<Country> countryList=countryService.getAll();
        for (Country country:countryList) {
            System.out.println(country.getCountryCode()+" "+
                    country.getCountryName()+" "+
                    country.getCountryContinent()+" "+
                    country.getCountryRegion()+" "+
                    country.getCountryPopulation()+" "+
                    country.getCountryLocalName()+" "+
                    country.getCountryGovernmentForm()+" "+
                    country.getCountryHeadOfState());
        }
        return "Tum country getirildi";
    }
    //This request may fail.Because Have overloading in CountryDao.So The machine do not know
    //which run.
    @GetMapping("/country/{countryCode}")
    public String getCountryCode(@PathVariable String countryCode){
        Country country=(Country) countryService.getByCode(countryCode);
        System.out.println(country.getCountryCode()+" "+
                country.getCountryName()+" "+
                country.getCountryContinent()+" "+
                country.getCountryRegion()+" "+
                country.getCountryPopulation()+" "+
                country.getCountryLocalName()+" "+
                country.getCountryGovernmentForm()+" "+
                country.getCountryHeadOfState());
        return "Yapilan istek gerceklesdi.";
    }
}
