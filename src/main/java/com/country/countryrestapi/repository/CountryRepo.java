package com.country.countryrestapi.repository;

import com.country.countryrestapi.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<Country,Long > {



}
