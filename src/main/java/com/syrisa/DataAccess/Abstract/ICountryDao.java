package com.syrisa.DataAccess.Abstract;

import com.syrisa.DataAccess.IEntityRepository;
import com.syrisa.Entities.Country;

public interface ICountryDao<T> extends IEntityRepository<T> {
    T getByCode(String t);
}
