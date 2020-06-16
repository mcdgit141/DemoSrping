package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.*;

import com.example.service.*;

@RestController
@RequestMapping("/demo")
public class DemoController {
	
	@Autowired
	private DemoService service;
	
	@GetMapping("/hello")
	public String getHello() {
		System.out.println("Hello Word");
		return "Hello Word" + service.getNom();
	}
	
	@GetMapping("/hello/{name}")
	public String getHelloWithParam(@PathVariable("name") String name) {
		System.out.println("Hello Word");
		return "Hello Word" + name;
	}

}
