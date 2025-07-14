package com.app.controller.study.jstl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.dto.study.Product;

@Controller
public class Jstl01Controller {
	
	
	// 동적처리가 가능하도록 활용하는 JSTL - 1
	@GetMapping("/jstl1")
	public String jstl1(Model model) {
		
		model.addAttribute("msg", "오늘은 공짜 커피~");
		
		Product product = new Product();
		product.setId("proId");
		product.setName("proName");
		
		model.addAttribute("product", product);
		
		//product가 여러개 있다고 가정! (-> Product 파일에 생성자 추가아아)
		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product("id1", "name1", 1));
		productList.add(new Product("id2", "name2", 2));
		productList.add(new Product("id3", "name3", 3));
		productList.add(new Product("id4", "name4", 4));
		productList.add(new Product("id5", "name5", 5));
		
		model.addAttribute("productList", productList);
		
		
		//조건부에 사용할 변수!
		//coffee	juice	water
		model.addAttribute("drinkType", "coffee");
		
		
		//if문에 사용할 변수!
		//user	admin
		//model.addAttribute("userType", "admin");
		model.addAttribute("userType", "user"); //버튼이 안보이게 만든 경우!
		
		//활용!
		//true : 로그인O		false : 로그인X
		model.addAttribute("isLogin", true);
		
		
		return "jstl/jstl1";
	}
	
	
	
	
	// 동적처리가 가능하도록 활용하는 JSTL - 2
	@GetMapping("/jstl2")
	public String jstl2(Model model) {
		
		model.addAttribute("msg1", "<부등호>");
		model.addAttribute("msg2", "&lt;부등호&gt;");
		//&lt; => less than
		//&gt; => greater than
		//html에서 사용하는 코드화된 특수기호
		
		model.addAttribute("msgXml", "<script>alert('경고!!')</script>");
									  //코드로 인식이 될 수가 있다!! (그래서 다르게 막아줘야함~)

		return "jstl/jstl2"; 
	}
	
	
}
