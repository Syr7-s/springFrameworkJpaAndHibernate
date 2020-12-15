package com.syrisa.DataAccess.Concrete;

import com.syrisa.DataAccess.Abstract.ICountryDao;
import com.syrisa.Entities.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class HibernateCountryDao implements ICountryDao<Country> {
    @Autowired
    private SessionFactory sessionFactory;
    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
    @Override
    @Transactional
    public List<Country> getAll() {
        return null;
    }

    @Override
    public Country getById(int id) {
        return null;
    }

    @Override
    public void add(Country country) {

    }

    @Override
    public void update(Country country) {

    }

    @Override
    public void delete(Country country) {

    }
}
