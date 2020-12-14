package com.syrisa.controller;

import com.syrisa.Entities.City;
import com.syrisa.Service.Abstract.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {
    private ICityService cityService;
    @Autowired
    public HomeController(ICityService cityService){
        this.cityService=cityService;
    }
    @GetMapping("/home")
    public List<City> home(){
        return this.cityService.getAll();
    }
}
