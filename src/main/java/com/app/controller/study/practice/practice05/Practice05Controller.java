package com.app.controller.study.practice.practice05;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.controller.study.practice.practice04.Practice04DTO;

	@Controller
	@RequestMapping("/practice05")
public class Practice05Controller {
	
	@GetMapping("/pathA")
	public String pathA() {
		return "practice/practice05/pathA";
	}
	
	@GetMapping("/pathCommon/A")
	public String pathAInfo(Model model) {
		
		Practice05DTO prac05DTO = new Practice05DTO();
		
		prac05DTO.setItemInfoA("A 상품정보");

		model.addAttribute("pathA", prac05DTO);
		
		return "practice/practice05/pathA";
	}
	
	
	@GetMapping("/pathB")
	public String pathB() {
		return "practice/practice05/pathB";
	}
	
	@GetMapping("/pathCommon/B")
	public String pathBInfo(Model model) {
		
		Practice05DTO prac05DTO = new Practice05DTO();
		
		prac05DTO.setItemInfoB("B 상품정보");

		model.addAttribute("pathB", prac05DTO);
		
		return "practice/practice05/pathB";
	}
	
	//주소창 입력 값에 따라 화면에 보이도록 설정
	@GetMapping("/pathCommon/{producName}")
	public String pathCommonA(@PathVariable String productName, Model model) {
		
		//경로에 있는 값 producName -> DB 조회
		//올바른 값인지 검증
		//그 정보에 맞는 데이터 획득 후 -> 화면 전달
		
		model.addAttribute("producName", productName);
		
		return "practice/practice05/pathA";
		//공통 페이지에서 사용!
	}
}
