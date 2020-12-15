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
  /*  @GetMapping("/allCity")
    public List<City> get(){
        return this.cityService.getAll();
    }
    @GetMapping("/city/{id}")
    public City getById(@PathVariable int id){
        return (City)this.cityService.getById(id);
    }
*/
    @GetMapping("/allCity")
    public String get(){
        List<City> cities=cityService.getAll();
        for (City city:cities) {
            System.out.println(city.getName()+" "+city.getDistrict());
        }
        return "Tum sehirler getirildi";
    }
    @GetMapping("/city/{id}")
    public String getById(@PathVariable int id){
        City city= (City) cityService.getById(id);
        System.out.println(city.getName()+" "+city.getDistrict());
        return id+" city getirildi.";
    }
    @PostMapping("city/add")
    public String add(){
        City city=new City(0,"Istanbul","TUR","Marmara Bolgesi",15000);
        cityService.add(city);
        return "Yeni sehir eklendi.";
    }
}
