package com.pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.entity.CountryJD;
import com.pack.repository.CountryJdRepository;

@RestController
@RequestMapping("/countryjd")
public class CountryJdcontroller {
	
	@Autowired
	CountryJdRepository countryJdRepository;
	
	@GetMapping("/all")
	public List<CountryJD> allCountry() {

		return countryJdRepository.getAllCountry();
	}

}
