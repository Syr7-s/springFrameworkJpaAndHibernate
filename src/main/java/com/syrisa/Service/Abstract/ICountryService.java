package com.syrisa.Service.Abstract;

import java.util.List;

public interface ICountryService<T> {
    List<T> getAll();
    T getByCode(String t);
    void add(T t);
    void update(T t);
    void delete(T t);
}
