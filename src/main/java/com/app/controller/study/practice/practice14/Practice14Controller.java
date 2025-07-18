package com.app.controller.study.practice.practice14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/practice14")
public class Practice14Controller {
	
	@Autowired
	//CupBean cupBean = new CupBean(); 요걸 직접 만들지 않고 어노테이션으로 자동완성해부림!
	CupBean cupBean;
	
	@Autowired
	PlateBean plateBean;

	
	@GetMapping("/fullOrder")
	public String fullOrder() {
		
		System.out.println("컵에 담긴 음료의 이름 - " + cupBean.getCoffeeBean().getName());
		System.out.println("접시에 담긴 디저트의 이름 - " + plateBean.getDessertBean().getName());
		
		return "practice/practice14/coffeList";
	}
	
	
	@GetMapping("/orderCoffee")
	public String orderCoffee() {

		System.out.println("컵에 담긴 음료의 이름 - " + cupBean.getCoffeeBean().getName());
		
		return "practice/practice14/coffeList";
	}
	
	
	@GetMapping("/orderDessert")
	public String orderDessert() {
		
		System.out.println("접시에 담긴 디저트의 이름 - " + plateBean.getDessertBean().getName());
		
		return "practice/practice14/coffeList";
	}
	
}
