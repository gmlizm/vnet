package com.aboo.vnet.service.ws.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aboo.vnet.service.ws.model.GetCountryRequest;
import com.aboo.vnet.service.ws.model.GetCountryResponse;

@Service
@WebService(serviceName = "countryService", portName = "countryPort")
public class CountryServiceImp implements CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	@WebMethod 
	public GetCountryResponse getCountry(@WebParam(name = "getCountryRequest") GetCountryRequest request) {
		GetCountryResponse response = new GetCountryResponse();
		response.setCountry(countryRepository.findCountry(request.getName()));

		return response;
	}

}
