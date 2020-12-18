package com.syrisa.DataAccess.Concrete;

import com.syrisa.DataAccess.Abstract.ICityDao;
import com.syrisa.Entities.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
        /*CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<City> criteriaQuery = criteriaBuilder.createQuery(City.class);
        Root<City> rootEntry = criteriaQuery.from(City.class);
        CriteriaQuery<City> tum = criteriaQuery.select(rootEntry);
        TypedQuery<City> cities = getCurrentSession().createQuery(tum);*/
        List<City> cities = getCurrentSession().createQuery("from City", City.class).getResultList();
        return cities;

    }

    @Override
    public City getById(int id) {
       /* CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<City> criteriaQuery = criteriaBuilder.createQuery(City.class);
        Root<City> root = criteriaQuery.from(City.class);
        Predicate predicateCityId = criteriaBuilder.equal(root.get("id"), id);
        criteriaQuery.select(root).where(predicateCityId);
        Query<City> query = getCurrentSession().createQuery(criteriaQuery);
        City city = query.getSingleResult();*/
        City city = getCurrentSession().get(City.class, id);
        return city;

    }

    @Override
    public void add(City city) {
        if (city.getId() == 0)
            getCurrentSession().save(city);
        else
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
