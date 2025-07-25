package com.app.controller.study.practice.practice16;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.CommonCode;
import com.app.dto.user.User;

@Controller
@RequestMapping("practice16")
public class Practice16Controller {
	
	@GetMapping("quiz1")
	public String quiz1() {
		return "practice/practice16/prac16";
	}
	
	
	@ResponseBody
	@GetMapping("quiz2")
	public String quiz2() {
		return "return text quiz2";
	}
	
	@ResponseBody
	@GetMapping("quiz3")
	public User quiz3() {
		
		User user = new User();
		user.setId("quizid");
		user.setPw("secret");
		user.setName("quiz이름");
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		
		return user;

	}
	
	
	
	
}
