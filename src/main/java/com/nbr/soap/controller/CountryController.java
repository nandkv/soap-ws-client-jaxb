package com.nbr.soap.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nbr.soap.service.CountryClient;
import com.nbr.soap.service.wsdl.GetCountryNameResponse;
import com.nbr.soap.service.wsdl.GetCountryResponse;

@RestController
public class CountryController {
	CountryClient countryClient;
	
	@Inject
	public CountryController(CountryClient countryClient) {
		this.countryClient = countryClient;
	}

	//eg: http://localhost:8082/country/Spain.xml or http://localhost:8082/country/Spain.json
	@RequestMapping(value = "/country/{name}", method = RequestMethod.GET, headers ={"Accept=application/json,application/xml"}, produces={"application/json", "application/xml"})
	public GetCountryResponse getCountry(@PathVariable String name) throws Exception{
		GetCountryResponse response = countryClient.getCountry(name);
		return response;
	}
	
	@RequestMapping(value = "/countryName/{name}", method = RequestMethod.GET, headers ={"Accept=application/json,application/xml"}, produces={"application/json", "application/xml"})
	public GetCountryNameResponse getCountryName(@PathVariable String name) throws Exception{
		GetCountryNameResponse response = countryClient.getCountryName(name);
		return response;
	}
	
}
