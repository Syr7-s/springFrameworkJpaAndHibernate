package com.syrisa.DataAccess.Concrete;

import com.syrisa.DataAccess.Abstract.ICityDao;
import com.syrisa.Entities.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class HibernateCityDao implements ICityDao<City> {
    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public List<City> getAll() {
        List<City> cities = getCurrentSession().createQuery("from City ", City.class).getResultList();
        return cities;

    }

    @Override
    public City getById(int id) {
        City city = getCurrentSession().get(City.class, id);
        return city;
    }

    @Override
    public void add(City city) {
        getCurrentSession().saveOrUpdate(city);
    }

    @Override
    public void update(City city) {
        getCurrentSession().saveOrUpdate(city);
    }

    @Override
    public void delete(City city) {
        City cityToDelete = getCurrentSession().get(City.class, city.getId());
        getCurrentSession().delete(cityToDelete);
    }
}
