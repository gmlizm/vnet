package com.aboo.vnet.service.ws.service;

import com.aboo.vnet.service.ws.model.GetCountryRequest;
import com.aboo.vnet.service.ws.model.GetCountryResponse;

public interface CountryService {

	GetCountryResponse getCountry(GetCountryRequest request);
}
