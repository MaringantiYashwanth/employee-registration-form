package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.pojo.Employee;
import com.example.demo.service.HelloService;

public class HelloController {
	@Autowired
	private HelloService service;

	@GetMapping("/hello")
	public String getHello() {
// Screen transition to hello.html
		return "hello";
	}

	@PostMapping("/hello")
	public String postRequest(@RequestParam("text1") String str, Model model) {
// Register the string received from the screen to Model
		model.addAttribute("sample", str);
// Screen transition to response.html
		return "hello/response";
	}

	@PostMapping("/hello/db")
	public String postDbRequest(@RequestParam("text2") String id, Model model) {
// Search one
		Employee employee = service.getEmployee(id);
// Save Search Results to Model
		model.addAttribute("employee", employee);
// Screen transition to db.html
		return "hello/db";
	}
}
