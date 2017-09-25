package com.aboo.vnet.service.publish.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aboo.vnet.service.publish.Greeting;

@RestController
public class TestRestApi {

	@RequestMapping("/greeting")
	public Greeting greeting(){
		return new Greeting(1L,"greeting1");
	}
}
