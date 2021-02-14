package com.country.countryrestapi.service;

import com.country.countryrestapi.exception.BadRequestException;
import com.country.countryrestapi.exception.ResourceNotFoundException;
import com.country.countryrestapi.model.Country;
import com.country.countryrestapi.repository.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CountryServiceImplementation implements CountryService {

    @Autowired
    private CountryRepo countryRepo;

    @Override
    public Country createCountry(Country country) {
        // Implementation of the method to create a country
        if(country.getCountry_name().isEmpty())
            throw new BadRequestException("Country name can not be empty");
        
        return countryRepo.save(country);
    }

    @Override
    public Country updateCountry(Country country) {
        // Implementation of the method to update a country

        Optional<Country> country_db = this.countryRepo.findById(country.getId());

            if(!country_db.isPresent())   throw new ResourceNotFoundException("Country not found with ID : " + country.getId());


        Country country_update = country_db.get();

            if(country.getCountry_name().isEmpty())
                throw new BadRequestException("Country name can not be empty");

                System.out.println(country.getPopulation());

            country_update.setCountry_name(country.getCountry_name());
            country_update.setCapital(country.getCapital());
            country_update.setPopulation(country.getPopulation());

            countryRepo.save(country_update);

            return country_update;



    }

    @Override
    public List<Country> getAllCountries() {
        // Implementation of the method to get all countries

        return this.countryRepo.findAll();

    }

    @Override
    public Country getCountryByID(long country_ID) {
        // Implementation of the method to get a country by ID

        Optional<Country> country_db = this.countryRepo.findById(country_ID);

        if(country_db.isPresent()){
            return  country_db.get();
        }else {
            System.out.println("Not found");
            throw new ResourceNotFoundException("Country not found with ID : " + country_ID);
        }
    }

    @Override
    public void deleteCountry(long country_ID) {
        // Implementation of the method to delete a country by its ID

        Optional<Country> country_db = this.countryRepo.findById(country_ID);

        if(country_db.isPresent()){
            this.countryRepo.delete(country_db.get());
        }else {
            System.out.println("Not found");
            throw new ResourceNotFoundException("Country not found with ID : " + country_ID);
        }

    }
}
