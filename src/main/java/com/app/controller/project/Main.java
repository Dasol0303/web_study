package com.app.controller.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Main {

	@GetMapping("/con/main")
	public String main() {
		return "project/main";
	}
}
