package com.syrisa.controller;

import com.syrisa.Entities.City;
import com.syrisa.Service.Abstract.ICityService;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private ICityService cityService;

    @GetMapping("/allCity")
    public String get(){
        List<City> cities=cityService.getAll();
        for (City city:cities) {
            System.out.println(city.getId()+" "+city.getName()+" "+city.getCountryCode()+" "+city.getDistrict()+" "+ city.getPopulation());
        }
        return "Tum sehirler getirildi";
    }
    @GetMapping("/city/{id}")
    public String getById(@PathVariable int id){
        City city= (City) cityService.getById(id);
        if (city!=null){
            System.out.println(city.getId()+" "+city.getName()+" "+city.getCountryCode()+" "+city.getDistrict()+" "+ city.getPopulation());
            return city.getId()+" "+city.getName()+" "+city.getCountryCode()+" "+city.getDistrict()+" "+ city.getPopulation();
        }
        else {
            return "Boyle bir sehir yok";
        }
    }
    @GetMapping("city/add")
    public String add(/*@RequestParam String cityName,
                      @RequestParam String countryCode,
                      @RequestParam String district,
                      @RequestParam int population*/)
    {
        String cityName="New York";
        String countryCode="USA";
        String district="MIAMI";
        int population=1500000;
        City city=new City(0,cityName,countryCode,district,population);
        cityService.add(city);

        return "Yeni sehir eklendi.";
    }
}
