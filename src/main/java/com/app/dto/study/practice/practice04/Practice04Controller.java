package com.app.dto.study.practice.practice04;

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
@RequestMapping("/practice04")
public class Practice04Controller {

	//  /practice04/request1-x?category=100&product=4000 
	
	//1-1)
	@GetMapping("/request1-1")
	public String request1(HttpServletRequest request) {
		System.out.println("request 활용");
		
		System.out.println(request.getParameter("category"));
		System.out.println(request.getParameter("product"));
		
		return "practice/practice04/prac04";
	}
	
	
	//1-2)
	@GetMapping("/request1-2")
	public String request2(@RequestParam(required = false, defaultValue = "category_null") String category, 
						   @RequestParam(required = false, defaultValue = "product_null") String product) {
		System.out.println("RequestParam 활용");
		
		System.out.println(category);
		System.out.println(product);
		
		return "practice/practice04/prac04";
	}
	
	//1-3)
	@GetMapping("/request1-3")
	public String request4(@ModelAttribute Practice04DTO prac04DTO) {
		
		System.out.println("자바 Dto 객체 활용");
		
		System.out.println(prac04DTO);

		return "practice/practice04/prac04";
	}
	
	//1-4)
	@GetMapping("/request1-4")
	public String request3(@RequestParam Map<String, String> paramMap) {
		
		System.out.println("RequestParam Map 활용");
		
		System.out.println(paramMap.get("category"));
		System.out.println(paramMap.get("product"));
		
		return "practice/practice04/prac04";
	}
	
	
// =========================================================================
	
	//2-1)
	@GetMapping("/viewData1-1")
	public String request5(HttpServletRequest request) {
		
		System.out.println("request 활용");
		
		request.setAttribute("response001", "100");
		request.setAttribute("response099", "4000");
		
		return "practice/practice04/prac04";
	}
	
	
	//2-2)
	@GetMapping("/viewData1-2")
	public String request6(Model model) {
		
		System.out.println("Model 활용");
		
		model.addAttribute("response001", "2000");
		model.addAttribute("response099", "600000");
		
		return "practice/practice04/prac04";
	}
	
	
	//2-3)
	@GetMapping("/viewData1-3")
	public ModelAndView request7(ModelAndView mav) {
		
		System.out.println("ModelAndView 활용");
		
		mav.setViewName("practice/practice04/prac04");
		mav.addObject("response001", "568952");
		mav.addObject("response099", "야홋!");
		
		return mav;
	}
	
	
	//2-4)
	@GetMapping("/viewData1-4")
	public String request8(Model model) {
		
		System.out.println("Model에 객체 단위로 전달 활용");
		
		Practice04DTO prac04DTO = new Practice04DTO();
		
		prac04DTO.setValue001("밸륭001");
		prac04DTO.setValue099("밸륭099");

		
		model.addAttribute("transferItem", prac04DTO);
		
		return "practice/practice04/prac04";
	}
	

	
	
}
