package com.syrisa.DataAccess.Concrete;

import com.syrisa.DataAccess.Abstract.ICityDao;
import com.syrisa.Entities.City;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.List;
@Repository
@Component("entityManagerCityDao")
public class HibernateCityDao implements ICityDao<City> {
   private EntityManager entityManager;
   public HibernateCityDao(EntityManager entityManager){
       this.entityManager=entityManager;
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
