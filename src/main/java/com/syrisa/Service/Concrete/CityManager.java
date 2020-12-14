package com.syrisa.Service.Concrete;

import com.syrisa.DataAccess.Abstract.ICityDao;
import com.syrisa.Entities.City;
import com.syrisa.Service.Abstract.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CityManager implements ICityService<City> {
    private ICityDao cityDao;
    @Autowired
    public CityManager(ICityDao cityDao){
        this.cityDao=cityDao;
    }
    @Override
    @Transactional
    public List<City> getAll() {
        return cityDao.getAll();
    }

    @Override
    @Transactional
    public City getById(int id) {
        return (City )cityDao.getById(id);
    }

    @Override
    @Transactional
    public void add(City city) {
        cityDao.add(city);
    }

    @Override
    public void update(City city) {
        cityDao.update(city);
    }

    @Override
    @Transactional
    public void delete(City city) {
        cityDao.delete(city);
    }
}
