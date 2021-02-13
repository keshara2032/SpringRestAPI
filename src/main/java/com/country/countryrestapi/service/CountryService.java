package com.country.countryrestapi.service;

import com.country.countryrestapi.model.Country;

import java.util.List;

public interface CountryService {

    Country createCountry(Country country); // Method for Creating a country
    Country updateCountry(Country country); // Method for Updating a country
    List<Country> getAllCountries(); // Method to retrieve all countries
    Country getCountryByID(long country_ID); // Method to retrieve specific country
    void deleteCountry(long country_ID); // Delete a particular country from DB


}
