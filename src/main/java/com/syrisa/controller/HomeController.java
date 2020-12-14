package com.syrisa.controller;

import com.syrisa.Entities.City;
import com.syrisa.Service.Abstract.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {
    private ICityService cityService;
    @Autowired
    public HomeController(ICityService cityService){
        this.cityService=cityService;
    }
    @GetMapping("/allCity")
    public List<City> get(){
        return this.cityService.getAll();
    }
    @GetMapping("/city/{id}")
    public City getById(@PathVariable int id){
        return (City)this.cityService.getById(id);
    }
}
