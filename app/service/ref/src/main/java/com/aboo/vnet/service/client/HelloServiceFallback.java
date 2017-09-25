package com.aboo.vnet.service.client;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceFallback implements IHelloService {

	@Override
	public String hello(String name) {
		return "sorry "+name;
	}

}
