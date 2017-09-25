package com.aboo.vnet.web.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aboo.vnet.service.client.IHelloService;

import io.swagger.annotations.ApiOperation;

@RestController
public class TestController {
	
	@Autowired
	private IHelloService helloService;

	@ApiOperation(value="获取用户列表", notes="")
	@GetMapping("/vnettest")
	public String vnettest(){
		return helloService.hello("abu");
	}
	
//	@ApiOperation(value="获取用户列表", notes="")
//	@GetMapping("/api/hello")
//	public String hello(){
//		return "hello world";
//	}
	
}
