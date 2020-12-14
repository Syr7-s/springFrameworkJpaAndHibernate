package com.syrisa.Service.Concrete;

import com.syrisa.DataAccess.Abstract.ICityDao;
import com.syrisa.Entities.City;
import com.syrisa.Service.Abstract.ICityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CityManager implements ICityService<City> {
    private ICityDao cityDao;
    @Autowired
    public CityManager(ICityDao cityDao){
        this.cityDao=cityDao;
    }
    @Override
    public List<City> getAll() {
        return null;
    }

    @Override
    public City getById(int id) {
        return null;
    }

    @Override
    public void add(City city) {

    }

    @Override
    public void update(City city) {

    }

    @Override
    public void delete(City city) {

    }
}
