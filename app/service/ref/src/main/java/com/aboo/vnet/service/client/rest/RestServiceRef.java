package com.aboo.vnet.service.client.rest;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Rest服务调用
 * @author lizm
 *
 */
@Service
public class RestServiceRef {

	private RestTemplate restTemplate;
	
	public RestServiceRef(RestTemplateBuilder restTemplateBuilder) {
		 this.restTemplate = restTemplateBuilder.build();
	}
	
}
