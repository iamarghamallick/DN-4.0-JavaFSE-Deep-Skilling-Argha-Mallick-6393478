package com.cognizant.spring_learn.repository;

import com.cognizant.spring_learn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {

}
