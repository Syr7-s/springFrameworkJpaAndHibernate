package com.syrisa.controller;

import com.syrisa.Entities.City;
import com.syrisa.Service.Abstract.ICityService;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    private ICityService cityService;
    @Autowired
    public CityController(ICityService cityService){
        this.cityService=cityService;
    }
    /*@GetMapping("/allCity")
    public List<City> get(){
        return this.cityService.getAll();
    }/*
    @GetMapping("/city/{id}")
    public City getById(@PathVariable int id){
        return (City)this.cityService.getById(id);
    }
*/
  /*  @GetMapping("/allCity")
    public String get(){
        List<City> cities=cityService.getAll();
        for (City city:cities) {
            System.out.println(city.getId()+" "+city.getName()+" "+city.getCountryCode()+" "+city.getDistrict()+" "+ city.getPopulation());
        }
        return "Tum sehirler getirildi";
    }*/
    @GetMapping("/city/{id}")
    public String getById(@PathVariable int id){
        City city= (City) cityService.getById(id);
        System.out.println(city.getId()+" "+city.getName()+" "+city.getCountryCode()+" "+city.getDistrict()+" "+ city.getPopulation());
        return city.getId()+" "+city.getName()+" "+city.getCountryCode()+" "+city.getDistrict()+" "+ city.getPopulation();
    }
    @GetMapping("city/add")
    public String add(@RequestParam String cityName,
                      @RequestParam String countryCode,
                      @RequestParam String district,
                      @RequestParam int population)
    {
        City city=new City(0,cityName,countryCode,district,population);
        cityService.add(city);

        return "Yeni sehir eklendi.";
    }
}
