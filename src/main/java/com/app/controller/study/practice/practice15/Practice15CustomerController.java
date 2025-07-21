package com.app.controller.study.practice.practice15;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/practice15")
public class Practice15CustomerController {
	
	@Autowired
	Practice15CustomerService practice15CostomerService;

	
	//고객 정보 등록 페이지로 연결
	@GetMapping("/registerCustomer")
	public String clientInfo(Model model) {
		return "practice/practice15/registerCustomer";
	}
	
	//등록페이지에서 사용자가 뭔가 저장할 정보를 입력한 후, 등록 요청
	//---> POST 요청
	
	@PostMapping("/registerCustomer")
	public String registerCustomerAction(@ModelAttribute Practice15Customer practice15Customer) {
		// 저장할 데이터가 담긴 객체 -> DB 저장
		// Controller  ->  Service  ->  DAO  ->  DB
		//			  DTO		    DTO		 DTO
		System.out.println("[Controller] registerCustomer");
		
		int result = practice15CostomerService.saveCustomer(practice15Customer);
		
		if(result > 0) {  //저장 성공
			return "practice/practice15/registerCustomer";
		} else {//저장 실패
			return "practice/practice15/registerCustomer";
		}
		
	}
	
	
}
