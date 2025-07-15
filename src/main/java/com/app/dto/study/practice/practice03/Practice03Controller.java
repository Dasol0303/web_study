package com.app.dto.study.practice.practice03;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/practice03")
public class Practice03Controller {

	// /practice03/request1-x?item=americano&type=coffee
	
	//1-1)
	@GetMapping("/request1-1")
	public String request1(HttpServletRequest request) {
		System.out.println("request 활용");
		
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("type"));
		
		return "practice/practice03/prac03";
	}
	
	
	//1-2)
	@GetMapping("/request1-2")
	public String request2(@RequestParam(required = false, defaultValue = "name_null") String name, 
						   @RequestParam(required = false, defaultValue = "type_null") String type) {
		System.out.println("RequestParam 활용");
		
		System.out.println(name);
		System.out.println(type);
		
		return "practice/practice03/prac03";
	}
	
	
	//1-3)
	@GetMapping("/request1-3")
	public String request3(@RequestParam Map<String, String> paramMap) {
		
		System.out.println("RequestParam Map 활용");
		
		System.out.println(paramMap.get("name"));
		System.out.println(paramMap.get("type"));
		
		return "practice/practice03/prac03";
	}
	
	
	//1-4)
	@GetMapping("/request1-4")
	public String request4(@ModelAttribute Practice03DTO prac03DTO) {
		
		System.out.println("자바 Dto 객체 활용");
		
		System.out.println(prac03DTO);

		return "practice/practice03/prac03";
	}
	
	
	//2-1)
	@GetMapping("/viewData1-1")
	public String request5(HttpServletRequest request) {
		
		System.out.println("request 활용");
		
		request.setAttribute("name", "americano");
		request.setAttribute("type", "coffee");
		
		return "practice/practice03/prac03";
	}
	
	
	//2-2)
	@GetMapping("/viewData1-2")
	public String request6(Model model) {
		
		System.out.println("Model 활용");
		
		model.addAttribute("name", "americano");
		model.addAttribute("type", "coffee");
		
		return "practice/practice03/prac03";
	}
	
	
	//2-3)
	@GetMapping("/viewData1-3")
	public ModelAndView request7(ModelAndView mav) {
		
		System.out.println("ModelAndView 활용");
		
		mav.setViewName("practice/practice03/prac03");
		mav.addObject("name", "americano");
		mav.addObject("type", "coffee");
		
		return mav;
	}
	
	
	//2-4)
	@GetMapping("/viewData1-4")
	public String request8(Model model) {
		
		System.out.println("Model에 객체 단위로 전달 활용");
		
		Practice03DTO prac03DTO = new Practice03DTO();
//		prac03DTO.setName("americano");
//		prac03DTO.setType("coffee");
		
		model.addAttribute("name", "americano");
		model.addAttribute("type", "coffee");
		
		model.addAttribute("drinkItem", prac03DTO);
		
		return "practice/practice03/prac03";
	}
	

	
	
}
