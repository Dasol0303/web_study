package com.app.dto.study.practice.practice07;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/practice07")
public class Practice07Controller {

	@GetMapping("/listTest")
	public String listTest(@RequestParam String type, Model model) {
	
		//str 반복 케이스
		//1) 그냥 jsp 내에서 고정 텍스트 반복
		
		//2) 전달할 스트링(메시지) 전달하고 그걸 반복
		
		//3) 전달할 메시지를 리스트 형태로 전달 반복
		
		
		// 화면 처리 케이스
		//1) type으로 아예 화면 자체를 구분
		
		//type : str 혹은 member 둘중에 하나로 확정 전제
		/*
		if(type.equals("str")) {
			
			//단일!
			model.addAttribute("msg", "스트링 리스트입니다.");
			
			//리스트!
			List<String> msgList = new ArrayList<String>();
			for(int i=1; i<=10; i++) {
				msgList.add("스트링 리스트입니다.");
			}
			
			model.addAttribute("msgList", msgList);
			
			
			return "practice/practice07/str";
		} else {	//member
			
			List<Practice07DTO> prac07DTOList = new ArrayList<Practice07DTO>();
			
//			prac07DTOList.add(new Practice07DTO("아이디1", "비번1", "이름1"));
//			prac07DTOList.add(new Practice07DTO("아이디2", "비번2", "이름2"));
//			prac07DTOList.add(new Practice07DTO("아이디3", "비번3", "이름3"));
//			prac07DTOList.add(new Practice07DTO("아이디4", "비번4", "이름4"));
//			prac07DTOList.add(new Practice07DTO("아이디5", "비번5", "이름5"));
			
			
			for(int i=1; i<=5; i++) {
				prac07DTOList.add(new Practice07DTO("아이디"+i, "비번"+i, "이름"+i));
			}
			
			model.addAttribute("member", prac07DTOList);

			return "practice/practice07/member";
		}
		*/
		
		//2) 같은 화면에서 type에 따라 동적으로 구분
		
		//jsp 파일 내에서 파라미터 처리할 거 넘겨주기!!
		// 이렇게 html에서 type 이름별로 처리하는 것도 가능하지만
		// if문을 사용해서 각 type 파라미터 값에 맞춰서 필요한 연산작업만 수행하는 것이 좋다!!
		model.addAttribute("type", type);
		
		model.addAttribute("msg", "스트링 리스트입니다.");
		
		List<Practice07DTO> prac07DTOList = new ArrayList<Practice07DTO>();
		
		for(int i=1; i<=5; i++) {
			prac07DTOList.add(new Practice07DTO("아이디"+i, "비번"+i, "이름"+i));
		}
		
		model.addAttribute("member", prac07DTOList);
		
		return "practice/practice07/prac07";
		
		
		
		//내가 하던 로직 ㅎㅎ
		/*
		model.addAttribute("str", "스트링 리스트입니다.");

//		Practice07DTO prac07DTO = new Practice07DTO();
				
		List<Practice07DTO> prac07DTOList = new ArrayList<Practice07DTO>();
		prac07DTOList.add(new Practice07DTO("아이디1", "비번1", "이름1"));
		prac07DTOList.add(new Practice07DTO("아이디2", "비번2", "이름2"));
		prac07DTOList.add(new Practice07DTO("아이디3", "비번3", "이름3"));
		prac07DTOList.add(new Practice07DTO("아이디4", "비번4", "이름4"));
		prac07DTOList.add(new Practice07DTO("아이디5", "비번5", "이름5"));
		

		model.addAttribute("member", prac07DTOList);
		//model.addAttribute("prac07DTO", prac07DTOList);
		
		return "practice/practice07/prac07";
		*/

	}
	
}
