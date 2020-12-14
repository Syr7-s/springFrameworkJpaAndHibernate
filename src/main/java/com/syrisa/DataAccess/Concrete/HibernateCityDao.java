package com.syrisa.DataAccess.Concrete;

import com.syrisa.DataAccess.Abstract.ICityDao;
import com.syrisa.Entities.City;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.List;
@Repository
@Component("entityCityDao")
public class HibernateCityDao implements ICityDao<City> {
   private EntityManager entityManager;
   @Autowired
   public HibernateCityDao(EntityManager entityManager){
       this.entityManager=entityManager;
   }
    @Override
    @Transactional
    public List<City> getAll() {
        List<City> cities=entityManager.createQuery("from City",City.class).getResultList();
        return cities;

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
