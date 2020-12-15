package com.syrisa.Service.Concrete;

import com.syrisa.DataAccess.Abstract.ICountryDao;
import com.syrisa.Entities.Country;
import com.syrisa.Service.Abstract.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryManager implements ICountryService<Country> {
    @Autowired
    private ICountryDao countryDao;
    public CountryManager(ICountryDao countryDao){
        this.countryDao=countryDao;
    }
    @Override
    public List<Country> getAll() {
        return this.countryDao.getAll();
    }

    @Override
    public Country getByCode(String t) {
        return (Country) this.countryDao.getByCode(t);
    }

    @Override
    public void add(Country country) {
        this.countryDao.add(country);
    }

    @Override
    public void update(Country country) {
        this.countryDao.update(country);
    }

    @Override
    public void delete(Country country) {
        this.countryDao.delete(country);
    }
}
