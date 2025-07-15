package com.app.dto.study.practice.practice06;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/practice06")
public class Practice06Controller {

	//1)
	@GetMapping("/ask-bmi")
	public String ask() {

		System.out.println("접속");

		return "practice/practice06/ask-bmi";
	}

	//2-1)
	//jsp 파일의 method="post"일 경우!!!
	@PostMapping("/result-bmi")
	public String result(HttpServletRequest request) {

		//ask-bmi 페이지에서 입력한 값
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("height"));
		System.out.println(request.getParameter("weight"));

		String name = request.getParameter("name");
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");

		//bmi 계산 		체중(kg) / 신장(m)^2
		double heightDb = Double.parseDouble(height);
		double weightDb = Double.parseDouble(weight);
		double bmi = weightDb / ( (heightDb/100)*(heightDb/100) );

		//결과화면 result-bmi 페이지에서 보여줄 값 세팅
		request.setAttribute("name", name);
		request.setAttribute("height", height);
		request.setAttribute("weight", weight);
		request.setAttribute("bmi", bmi);

		return "practice/practice06/result-bmi";
	}


	//2-2)
	//RequsetParam의 String과 Model로 받을 경우!
	@PostMapping("/result-bmi02")
	public String result02(@RequestParam String name,
			@RequestParam String height,
			@RequestParam String weight,
			Model model) {

		//ask-bmi 페이지에서 입력한 값
		System.out.println(name);
		System.out.println(height);
		System.out.println(weight);

		//bmi 계산 		체중(kg) / 신장(m)^2
		double heightDb = Double.parseDouble(height);
		double weightDb = Double.parseDouble(weight);
		double bmi = weightDb / ( (heightDb/100)*(heightDb/100) );

		model.addAttribute("name", name);
		model.addAttribute("height", height);
		model.addAttribute("weight", weight);
		model.addAttribute("bmi", bmi);

		return "practice/practice06/result-bmi";
	}


	//2-3)
	@PostMapping("/result-bmi03")
	//@RequestParam -> 이걸 넣어줘야 입력값을 전달 받을 수 있음!!
	public String result03(@RequestParam Map<String, String> paramMap, Model model) {

		//ask-bmi 페이지에서 입력한 값
		System.out.println(paramMap.get("name"));
		System.out.println(paramMap.get("height"));
		System.out.println(paramMap.get("weight"));

		String name = paramMap.get("name");
		String height = paramMap.get("height");
		String weight = paramMap.get("weight");

		//bmi 계산 		체중(kg) / 신장(m)^2
		double bmi = calculateBmiStr(height, weight);

		//결과화면 result-bmi 페이지에서 보여줄 값 세팅
		model.addAttribute("name", name);
		model.addAttribute("height", height);
		model.addAttribute("weight", weight);
		model.addAttribute("bmi", bmi);

		return "practice/practice06/result-bmi";
	}


	//2-4)
//	@PostMapping("/result-bmi04")
	@RequestMapping("/result-bmi04") //get, post 둘 다 받을 수 있는 형태
	public String result04(@ModelAttribute Practice06DTO prac06DTO, Model model) { //DTO불러오기!

		//ask-bmi 페이지에서 입력한 값
		System.out.println(prac06DTO.getName());
		System.out.println(prac06DTO.getHeight());
		System.out.println(prac06DTO.getWeight());

		String name = prac06DTO.getName();
		String height = prac06DTO.getHeight();
		String weight = prac06DTO.getWeight();

		//bmi 계산 		체중(kg) / 신장(m)^2
		double bmi = calculateBmiStr(height, weight);

		prac06DTO.setBmi(bmi);

		//결과화면 result-bmi 페이지에서 보여줄 값 세팅

		/*
			model.addAttribute("name", name);
			model.addAttribute("height", height);
			model.addAttribute("weight", weight);
			model.addAttribute("bmi", bmi);
		 */
		model.addAttribute("prac06DTO", prac06DTO);


		return "practice/practice06/result-bmi";
	}


	//bmi 계산하는 메소드
	public double calculateBmiDb(double height, double weight) {
		//double bmi = weight / ( (height/100)*(height/100) );

		double bmi = weight / Math.pow( (height/100), 2);

		return bmi;
	}

	public double calculateBmiStr(String height, String weight) {
		double heightDb = Double.parseDouble(height);
		double weightDb = Double.parseDouble(weight);

		return calculateBmiDb(heightDb, weightDb);
	}

}
