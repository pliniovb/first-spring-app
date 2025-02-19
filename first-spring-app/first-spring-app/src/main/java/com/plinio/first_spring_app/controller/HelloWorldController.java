package com.plinio.first_spring_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.plinio.first_spring_app.domain.User;
import com.plinio.first_spring_app.service.HelloWorldService;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {
	
	@Autowired /**  injects dependencies	
	prevents need to create a instance
	e.g.:
	public HelloWorldController(HelloWorldService helloWorldService) {
		this.helloWolrdService = helloWorldService;
	}**/
	private HelloWorldService helloWolrdService;
	
	
	@GetMapping
	public String helloWorld() {
		return helloWolrdService.helloWorld("Plinio");
	}
	
	@PostMapping("/{id}")
	public String helloWorldPost(@PathVariable("id") String id, @RequestParam(value = "filter", defaultValue = "none") String filter, @RequestBody User body) {
		return "Hellow World " + body.getName() + id + filter;
	}
	
	
	
}
