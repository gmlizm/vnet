package com.aboo.vnet.web.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/error")
public class ErrorController {
	
	//@RequestMapping("/error.htm")
	public String error(){
		return "error";
	}
	
	
	@RequestMapping("/testview.xlsx")
	public String testxlsx(Model model){
//		SysUser user = new SysUser();
//		user.setUid(1L);
//		user.setUsername("admin");
//		model.addAttribute("user", user);
		return "xlsxView";
	}
	
	@RequestMapping("/testview.xls")
	public String testxls(Model model){
//		SysUser user = new SysUser();
//		user.setUid(1L);
//		user.setUsername("admin");
//		model.addAttribute("user", user);
		return "xlsView";
	}
	
	@RequestMapping("/testview.pdf")
	public String testpdf(Model model){
//		SysUser user = new SysUser();
//		user.setUid(1L);
//		user.setUsername("admin");
//		model.addAttribute("user", user);
		return "pdfView";
	}
	
}
