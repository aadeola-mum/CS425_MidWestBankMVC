package edu.mum.cs.cs425.midwestenbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(value= {"","/","/midwestenbank", "/home"})
	public String displayHomePage() {
		return "home/index";
	}
}
