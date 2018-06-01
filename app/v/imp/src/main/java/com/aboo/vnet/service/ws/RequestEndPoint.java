//package com.aboo.vnet.service.ws;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ws.server.endpoint.annotation.Endpoint;
//import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
//import org.springframework.ws.server.endpoint.annotation.RequestPayload;
//import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
//
//import com.aboo.vnet.service.ws.model.GetCountryRequest;
//import com.aboo.vnet.service.ws.model.GetCountryResponse;
//import com.aboo.vnet.service.ws.service.CountryRepository;
//
////@Endpoint
//public class RequestEndPoint {
//	
//	@Autowired
//	private CountryRepository countryRepository;
//
//	@PayloadRoot(localPart = "getCountryRequest")
//	@ResponsePayload
//	public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
//		GetCountryResponse response = new GetCountryResponse();
//		response.setCountry(countryRepository.findCountry(request.getName()));
//
//		return response;
//	}
//
//}
