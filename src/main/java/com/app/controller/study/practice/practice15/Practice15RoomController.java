package com.app.controller.study.practice.practice15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Practice15RoomController {

	@Autowired
	Practice15RoomService pracitce15RoomService;
	
	@GetMapping("practice15/registerRoom")
	public String registerRoom() {
		return "practice/practice15/registerRoom";
	}
	
	@PostMapping("practice15/registerRoom")
	public String registerRoomAction(Practice15Room practice15Room) {
		//입혁한 데이터 요청받는
		
		//저장하는 과정  (service)
		
		int result = pracitce15RoomService.saveRoom(practice15Room);
		
		if(result > 0) {  //저장 성공
			return "practice/practice15/registerRoom";
		} else {//저장 실패
			return "practice/practice15/registerRoom";
		}

	}
	
}
