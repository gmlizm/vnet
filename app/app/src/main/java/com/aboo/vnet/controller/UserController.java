package com.aboo.vnet.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

//	@GetMapping("/oauth/user")
//	public Object user() {
//		return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//	}
	
	@GetMapping("/oauth/user")
    public Principal user(Principal principal) { 
        return principal;
    }
	
    @GetMapping("/user")
    public Principal user1(Principal user){
        return user;
    }
}
