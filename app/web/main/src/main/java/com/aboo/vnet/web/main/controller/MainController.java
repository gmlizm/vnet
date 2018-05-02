package com.aboo.vnet.web.main.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.aboo.vnet.core.service.UserService;

@Controller
public class MainController extends SysController {
	
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
    public String index(ModelMap modelMap, WebRequest request, HttpServletResponse response) throws Exception {

		return root(modelMap,request,response);
	}

	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root(ModelMap modelMap, WebRequest request, HttpServletResponse response) throws Exception {
//    	PrintWriter pw = response.getWriter();
//    	pw.print("hello world !");
//    	pw.flush();
//    	User user = userService.findByName("root");
//    	System.out.println(user.getId());
//    	System.out.println(user.getUname());
    	return "index";
    }

    /*
     * @RequestMapping("/json.htm")
     * 
     * @ResponseBody public User getJson(ModelMap modelMap, HttpServletRequest
     * request, HttpServletResponse response) { return userService.getUser(); }
     */

    //@MessageMapping("/msg.htm")
    public Map<String, Object> messgae(ModelMap modelMap,
	    HttpServletRequest request) {
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("id", 2);
	map.put("name", "zhangsan");
	return map;
    }

}