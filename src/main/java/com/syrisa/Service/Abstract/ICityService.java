package com.syrisa.Service.Abstract;

import java.util.List;

public interface ICityService<T> {
    List<T> getAll();
    T getById(int id);
    void add(T t);
    void update(T t);
    void delete(T t);
}
