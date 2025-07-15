package com.app.controller.study.practice.practice08;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/practice08")
public class Practice08Controller {

	@GetMapping("/member")
	public String member(@RequestParam String auth, Model model) {

		if( !( auth.equals("basic") || auth.equals("manager") || auth.equals("admin") ) ) {
		
			//위에 세 파라미터 값 외에는 오류 페이지가 뜨도록!!
			return "파라미터 값이 잘못된 페이지!!";
		}
		
		
		model.addAttribute("auth", auth);
		/*
		if (auth.equals("basic")) {

			List<Member> memberList = new ArrayList<Member>();

			memberList.add(new Member("user1", "pass123", "홍길동", "basic"));
			memberList.add(new Member("user3", "pass789", "이영희", "basic"));
			memberList.add(new Member("user5", "passdef", "정재영", "basic"));
			memberList.add(new Member("user6", "passxyz", "최성민", "basic"));
			memberList.add(new Member("user8", "pass456", "장성호", "basic"));
			memberList.add(new Member("user9", "pass789", "신지수", "basic"));

			model.addAttribute("member", memberList);


		} else if (auth.equals("manager")) {

			List<Member> memberList = new ArrayList<Member>();

			memberList.add(new Member("user2", "pass456", "김철수", "manager"));
			memberList.add(new Member("user4", "passabc", "박민지", "manager"));
			memberList.add(new Member("user7", "pass123", "서지원", "manager"));
			memberList.add(new Member("user10", "passabc", "한영희", "manager"));

			model.addAttribute("member", memberList);
		} else {

			List<Member> memberList = new ArrayList<Member>();

			memberList.add(new Member("user1", "pass123", "홍길동", "basic"));
			memberList.add(new Member("user2", "pass456", "김철수", "manager"));
			memberList.add(new Member("user3", "pass789", "이영희", "basic"));
			memberList.add(new Member("user4", "passabc", "박민지", "manager"));
			memberList.add(new Member("user5", "passdef", "정재영", "basic"));
			memberList.add(new Member("user6", "passxyz", "최성민", "basic"));
			memberList.add(new Member("user7", "pass123", "서지원", "manager"));
			memberList.add(new Member("user8", "pass456", "장성호", "basic"));
			memberList.add(new Member("user9", "pass789", "신지수", "basic"));
			memberList.add(new Member("user10", "passabc", "한영희", "manager"));

			model.addAttribute("member", memberList);

		}
		 */

		List<Member> memberList = new ArrayList<Member>();

		memberList.add(new Member("user1", "pass123", "홍길동", "basic"));
		memberList.add(new Member("user2", "pass456", "김철수", "manager"));
		memberList.add(new Member("user3", "pass789", "이영희", "basic"));
		memberList.add(new Member("user4", "passabc", "박민지", "manager"));
		memberList.add(new Member("user5", "passdef", "정재영", "basic"));
		memberList.add(new Member("user6", "passxyz", "최성민", "basic"));
		memberList.add(new Member("user7", "pass123", "서지원", "manager"));
		memberList.add(new Member("user8", "pass456", "장성호", "basic"));
		memberList.add(new Member("user9", "pass789", "신지수", "basic"));
		memberList.add(new Member("user10", "passabc", "한영희", "manager"));


		List<Member> viewMemberList = new ArrayList<Member>();
		
		//1) 서버에서 리스트 전체 넘기고, 화면에서 JSTL로 구분 출력 했을 때
		
//		if (auth.equals("basic")) {
//
//			for(Member m : memberList) {
//				//오우... 쌤 이거 제가 찾던건데 결국 못 찾았어서 너무 슬프네요....ㅠ
//				if(m.getType().equals("baisc")) {
//					viewMemberList.add(m);
//				}
//			}
//
//		} else if (auth.equals("manager")) {
//
//			for(Member m : memberList) {
//
//				if(m.getType().equals("manager")) {
//					viewMemberList.add(m);
//				}
//			}
//
//		} else {
//			viewMemberList = memberList;
//		}
//
//
//		model.addAttribute("viewMemberList", viewMemberList);

		
		if (auth.equals("basic") || auth.equals("manager")) {
			for(Member m : memberList) {
				if(m.getType().equals(auth)) { //auth 값에 basic인지 manager인지 값이 들어있을 거라서 이렇게 줄일 수 있음!!
					viewMemberList.add(m);
				}
			}
		} else {
			viewMemberList = memberList;
		}

		model.addAttribute("viewMemberList", viewMemberList);

		
		
		//2) 화면(view) jstl 구분해서 처리
		
		model.addAttribute("memberList", memberList);
		
		
		return "practice/practice08/prac08";
	}
	
	

}
