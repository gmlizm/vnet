package com.aboo.vnet.web.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aboo.vnet.core.service.UserService;

@RestController
public class TestController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/stest")
	public String test() {
		return "44";
	}
}
