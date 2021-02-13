package com.country.countryrestapi.controller;

import com.country.countryrestapi.exception.ResourceNotFoundException;
import com.country.countryrestapi.model.Country;
import com.country.countryrestapi.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    // API for requesting all countries
    @GetMapping("/countries")
    public ResponseEntity<List<Country>> getAllCountries(){
        return ResponseEntity.ok().body(countryService.getAllCountries());
    }

    // API for requesting for a specific country
    @GetMapping("/countries/{country_id}")
    public ResponseEntity<Country> getCountry(@PathVariable long country_id){
        return ResponseEntity.ok().body(countryService.getCountryByID(country_id));
    }

    // API for creating a country
    @PostMapping("/countries")
    public ResponseEntity<Country> createCountry(@RequestBody Country country){

        return ResponseEntity.ok().body(this.countryService.createCountry(country));

    }

    // API for updating a country
    @PutMapping("/countries/{country_id}")
    public ResponseEntity<Country> updateCountry(@PathVariable long country_id, @Validated @RequestBody Country country){

        country.setId(country_id);
        return ResponseEntity.ok().body(this.countryService.updateCountry(country));

    }

    // API for deleting a country
    @DeleteMapping("/countries/{country_id}")
    public ResponseEntity<?> deleteCountry(@PathVariable long country_id){

            this.countryService.deleteCountry(country_id);

              return new ResponseEntity<>("Deleted country with id : "+country_id, HttpStatus.OK);


    }
}
