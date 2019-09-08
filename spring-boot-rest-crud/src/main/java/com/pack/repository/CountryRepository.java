package com.pack.repository;

import org.springframework.data.repository.CrudRepository;

import com.pack.entity.Country;

public interface CountryRepository extends CrudRepository<Country, Integer> {

}
