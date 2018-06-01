package com.aboo.vnet.service.ws.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.aboo.vnet.service.ws.model.Country;
import com.aboo.vnet.service.ws.model.Currency;

@Component
public class CountryRepository {
	private static final List<Country> countries = new ArrayList<Country>();

	@PostConstruct
	public void initData() {
		Country spain = new Country();
		spain.setName("Spain");
		spain.setCapital("Madrid");
		spain.setCurrency(Currency.EUR);
		spain.setPopulation(46704314);

		countries.add(spain);

		Country poland = new Country();
		poland.setName("Poland");
		poland.setCapital("Warsaw");
		poland.setCurrency(Currency.PLN);
		poland.setPopulation(38186860);

		countries.add(poland);

		Country uk = new Country();
		uk.setName("United Kingdom");
		uk.setCapital("London");
		uk.setCurrency(Currency.GBP);
		uk.setPopulation(63705000);
		countries.add(uk);
	}

	public Country findCountry(String name) {

		Country result = null;

		for (Country country : countries) {
			if (name.equals(country.getName())) {
				result = country;
			}
		}

		return result;
	}
	
	
    public static String md5(String data){
        if(StringUtils.isBlank(data)){
            return null;
        }

        byte[] encryptData = DigestUtils.md5(data);
        String result = Hex.encodeHexString(encryptData).toUpperCase();
        return result;
    }

}