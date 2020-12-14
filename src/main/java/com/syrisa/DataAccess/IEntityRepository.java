package com.syrisa.DataAccess;

import java.util.List;

public interface IEntityRepository<T> {
    List<T> getAll();
    T getById(int id);
    void add(T t);
    void update(T t);
    void delete(T t);
}
