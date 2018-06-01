package com.aboo.vnet.service.ws.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.aboo.vnet.service.ws.model.Dog;

@Service
@WebService(serviceName = "helloService", portName = "helloPort")
public class HelloServiceImp implements HelloService {

	@WebMethod 
	public Dog sayHello(String myname) {
		try {
			Dog dog = new Dog();
			dog.setName(myname);
			dog.setSex(true);
			return dog;

		} catch (java.lang.Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

}